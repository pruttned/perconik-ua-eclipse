package sk.stuba.fiit.perconik.preferences.persistence;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Set;
import sk.stuba.fiit.perconik.core.Listener;
import sk.stuba.fiit.perconik.core.Resource;
import sk.stuba.fiit.perconik.core.Resources;
import sk.stuba.fiit.perconik.core.services.Services;
import sk.stuba.fiit.perconik.core.services.resources.ResourceProvider;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

public final class ResourcePersistenceData implements Serializable
{
	private static final long serialVersionUID = 6677144113746518278L;

	private final transient boolean registered;
	
	private final transient Class<? extends Listener> type;

	private final transient String name;
	
	private final transient Resource<?> resource;
	
	ResourcePersistenceData(final boolean registered, final Class<? extends Listener> type, final String name, final Resource<?> resource)
	{
		this.registered = registered;
		this.type       = checkType(type);
		this.name       = checkName(name);
		this.resource   = resource instanceof Serializable ? resource : null;
		
		Preconditions.checkArgument(resource == null || name.equals(resource.getName()));
	}
	
	public static final <L extends Listener> ResourcePersistenceData of(final Class<L> type, final Resource<? super L> resource)
	{
		 return new ResourcePersistenceData(Resources.isRegistred(type, resource), type, resource.getName(), resource);
	}
	
	public static final Set<ResourcePersistenceData> snapshot()
	{
		ResourceProvider provider = Services.getResourceService().getResourceProvider();
		
		Set<ResourcePersistenceData> data = Sets.newHashSet();
		
		for (Class<? extends Listener> type: provider.types())
		{
			for (Resource<?> resource: provider.forType(type))
			{
				data.add(new ResourcePersistenceData(Resources.isRegistred(type, resource), type, resource.getName(), resource));
			}
		}
		
		return data;
	}

	static final Class<? extends Listener> checkType(final Class<? extends Listener> type)
	{
		Preconditions.checkArgument(Listener.class.isAssignableFrom(type));
		
		return type;
	}

	static final String checkName(final String name)
	{
		Preconditions.checkArgument(!name.isEmpty());
		
		return name;
	}

	private static final class SerializationProxy implements Serializable
	{
		private static final long serialVersionUID = 4583906053454610999L;

		private final boolean registered;
		
		private final Class<? extends Listener> type;
		
		private final String name;

		private final Resource<?> resource;

		private SerializationProxy(final ResourcePersistenceData data)
		{
			this.registered = data.isRegistred();
			this.type       = data.getListenerType();
			this.name       = data.getResourceName();
			this.resource   = data.getSerializedResource();
		}
		
		static final SerializationProxy of(final ResourcePersistenceData data)
		{
			return new SerializationProxy(data);
		}

		private final Object readResolve() throws InvalidObjectException
		{
			try
			{
				return new ResourcePersistenceData(this.registered, this.type, this.name, this.resource);
			}
			catch (RuntimeException e)
			{
				throw new InvalidObjectException("Unknown deserialization error");
			}
		}
	}

	@SuppressWarnings({"static-method", "unused"})
	private final void readObject(final ObjectInputStream in) throws InvalidObjectException
	{
		throw new InvalidObjectException("Serialization proxy required");
	}

	private final Object writeReplace()
	{
		return SerializationProxy.of(this);
	}
	
	@Override
	public final boolean equals(final Object o)
	{
		if (this == o)
		{
			return true;
		}

		if (!(o instanceof ResourcePersistenceData))
		{
			return false;
		}

		ResourcePersistenceData other = (ResourcePersistenceData) o;

		return this.type == other.type && this.name.equals(other.name);
	}

	@Override
	public final int hashCode()
	{
		return 31 * (31 + this.type.hashCode()) + this.name.hashCode();
	}
	
	public static final Set<ResourcePersistenceData> applyRegisteredMark(final Set<ResourcePersistenceData> data)
	{
		Set<ResourcePersistenceData> result = Sets.newHashSetWithExpectedSize(data.size());
		
		for (ResourcePersistenceData o: data)
		{
			result.add(o.applyRegisteredMark());
		}
		
		return result;
	}

	public static final Set<ResourcePersistenceData> updateRegisteredMark(final Set<ResourcePersistenceData> data)
	{
		Set<ResourcePersistenceData> result = Sets.newHashSetWithExpectedSize(data.size());
		
		for (ResourcePersistenceData o: data)
		{
			result.add(o.updateRegisteredMark());
		}
		
		return result;
	}
	
	public final ResourcePersistenceData applyRegisteredMark()
	{
		Resource<?> resource = this.getResource();
		
		boolean status = Resources.isRegistred(this.type, resource);
		
		if (this.registered == status)
		{
			return this;
		}

		if (this.registered)
		{
			Unsafe.register(this.type, resource);
		}
		else
		{
			Unsafe.unregister(this.type, resource);
		}
		
		return new ResourcePersistenceData(status, this.type, this.name, this.resource);
	}
	
	public final ResourcePersistenceData updateRegisteredMark()
	{
		boolean status = this.isRegistred();
		
		if (this.registered == status)
		{
			return this;
		}
		
		return new ResourcePersistenceData(status, this.type, this.name, this.resource);
	}

	public final ResourcePersistenceData markRegistered(final boolean status)
	{
		if (this.registered == status)
		{
			return this;
		}
		
		return new ResourcePersistenceData(status, this.type, this.name, this.resource);
	}

	public final boolean isRegistred()
	{
		return Resources.isRegistred(this.type, this.getResource());
	}

	public final boolean hasRegistredMark()
	{
		return this.registered;
	}
	
	public final boolean hasSerializedResource()
	{
		return this.resource != null;
	}
	
	public final Class<? extends Listener> getListenerType()
	{
		return this.type;
	}

	public final Resource<?> getResource()
	{
		if (this.resource != null)
		{
			return this.resource;
		}
		
		return Services.getResourceService().getResourceProvider().forName(this.name);
	}
	
	public final String getResourceName()
	{
		return this.name;
	}

	public final Resource<?> getSerializedResource()
	{
		return this.resource;
	}
}