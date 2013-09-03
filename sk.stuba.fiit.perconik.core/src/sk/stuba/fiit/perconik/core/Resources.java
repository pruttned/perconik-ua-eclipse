package sk.stuba.fiit.perconik.core;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;
import sk.stuba.fiit.perconik.core.services.Services;
import sk.stuba.fiit.perconik.core.services.resources.ResourceManager;
import sk.stuba.fiit.perconik.core.services.resources.ResourceNamesSupplier;
import sk.stuba.fiit.perconik.core.services.resources.ResourceProvider;
import sk.stuba.fiit.perconik.core.services.resources.ResourceService;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.SetMultimap;

public final class Resources
{
	private Resources()
	{
		throw new AssertionError();
	}

	static final ResourceService service()
	{
		return Services.getResourceService();
	}
	
	static final ResourceProvider provider()
	{
		return service().getResourceProvider();
	}
	
	static final ResourceManager manager()
	{
		return service().getResourceManager();
	}
	
	public static final <L extends Listener> void register(final Class<L> type, final Resource<? super L> resource)
	{
		manager().register(type, resource);
	}

	public static final <L extends Listener> void registerAll(final Class<L> type, Iterable<Resource<? super L>> resources)
	{
		ResourceManager manager = manager();
		
		for (Resource<? super L> resource: resources)
		{
			manager.register(type, resource);
		}
	}

	public static final void registerAll(final ResourceNamesSupplier supplier)
	{
		for (Entry<Class<? extends Listener>, Collection<String>> entry: supplier.get().asMap().entrySet())
		{
			registerByNames(entry.getKey(), entry.getValue());
		}
	}
	
	private static final <L extends Listener> void registerByNames(final Class<L> type, final Iterable<String> names)
	{
		ResourceProvider provider = provider();
		ResourceManager  manager  = manager();
		
		BiMap<String, Resource<L>> resources = toResourceNameMap(provider.forType(type));
		
		for (String name: names)
		{
			Resource<L> resource = resources.get(name);
			
			if (resource == null)
			{
				throw new IllegalStateException("Resource provider does not know resource named " + name + " for type " + type.getName());
			}
			
			manager.register(type, resource);
		}
	}
	
	public static final <L extends Listener> void unregister(final Class<L> type, final Resource<? super L> resource)
	{
		manager().unregister(type, resource);
	}
	
	public static final <L extends Listener> void unregisterAll()
	{
		unregisterAll(Listener.class);
	}
	
	public static final <L extends Listener> void unregisterAll(final Class<L> type)
	{
		manager().unregisterAll(type);
	}

	public static final <L extends Listener> Set<Resource<? extends L>> assignable(final Class<L> type)
	{
		return manager().assignable(type);
	}

	public static final <L extends Listener> Set<Resource<? super L>> registrable(final Class<L> type)
	{
		return manager().registrable(type);
	}

	public static final SetMultimap<Class<? extends Listener>, Resource<?>> registrations()
	{
		return manager().registrations();
	}

	public static final boolean isRegistered(final Class<? extends Listener> type, final Resource<?> resource)
	{
		// TODO extend manager interface
		
		return registrations().containsEntry(type, resource);
	}
	
	public static final <L extends Listener> BiMap<String, Resource<L>> toResourceNameMap(final Set<Resource<L>> resources)
	{
		BiMap<String, Resource<L>> map = HashBiMap.create(resources.size());
		
		for (Resource<L> resource: resources)
		{
			map.put(resource.getName(), resource);
		}
		
		return map;
	}
}
