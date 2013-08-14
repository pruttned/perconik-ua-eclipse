package sk.stuba.fiit.perconik.debug.services;

import sk.stuba.fiit.perconik.core.Listener;
import sk.stuba.fiit.perconik.core.services.ListenerProvider;
import sk.stuba.fiit.perconik.debug.Debug;
import sk.stuba.fiit.perconik.debug.DebugListeners;
import sk.stuba.fiit.perconik.debug.DebugObjectProxy;
import sk.stuba.fiit.perconik.eclipse.core.runtime.PluginConsole;

public class DebugListenerProviderProxy extends DebugObjectProxy<ListenerProvider> implements DebugListenerProvider
{
	private DebugListenerProviderProxy(final ListenerProvider provider, final PluginConsole console)
	{
		super(provider, console);
	}

	public static final DebugListenerProviderProxy of(final ListenerProvider provider)
	{
		return of(provider, Debug.getDefaultConsole());
	}

	public static final DebugListenerProviderProxy of(final ListenerProvider provider, final PluginConsole console)
	{
		if (provider instanceof DebugListenerProviderProxy)
		{
			return (DebugListenerProviderProxy) provider;
		}
		
		return new DebugListenerProviderProxy(provider, console);
	}
	
	public final <L extends Listener> L forClass(final Class<L> type)
	{
		this.put("Requesting listener for ", type, " ... ");
		
		L listener = this.delegate().forClass(type);
		
		this.print(listener != null ? "done (" + DebugListeners.toString(listener) + ")" : "failed");
		
		return listener;
	}

	public final Class<? extends Listener> loadClass(final String name) throws ClassNotFoundException
	{
		return this.delegate().loadClass(name);
	}

	public final Iterable<Class<? extends Listener>> loadedClasses()
	{
		return this.delegate().loadedClasses();
	}
}