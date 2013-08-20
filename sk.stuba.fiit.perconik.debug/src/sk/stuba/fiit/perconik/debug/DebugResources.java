package sk.stuba.fiit.perconik.debug;

import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import sk.stuba.fiit.perconik.core.Listener;
import sk.stuba.fiit.perconik.core.Resource;
import sk.stuba.fiit.perconik.core.Resources;
import sk.stuba.fiit.perconik.utilities.SmartStringBuilder;
import sk.stuba.fiit.perconik.utilities.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

public final class DebugResources
{
	private DebugResources()
	{
		throw new AssertionError();
	}
	
	public static final String toString(final Class<? extends Resource<?>> type)
	{
		return type.getName();
	}
	
	public static final String toString(final Resource<?> resource)
	{
		return Strings.toStringFallback(resource);
	}
	
	public static final void printRegistered()
	{
		printRegistered(Debug.getDefaultConsole());
	}
	
	public static final void printRegistered(final DebugConsole console)
	{
		console.put(dumpRegistered());
	}
	
	public static final void printRegistrations()
	{
		printRegistrations(Debug.getDefaultConsole());
	}
	
	public static final void printRegistrations(final DebugConsole console)
	{
		console.put(dumpRegistrations());
	}

	static final String dumpRegistered()
	{
		SmartStringBuilder builder = new SmartStringBuilder();
		
		builder.appendln("Registered resources:").tab();
		
		List<Resource<?>> resources = Lists.newArrayList(Resources.registrations().values());

		if (!resources.isEmpty())
		{
			Collections.sort(resources, Strings.toStringComparator());
			
			for (Resource<?> resource: resources)
			{
				builder.appendln(toString(resource));
			}
		}
		else
		{
			builder.appendln("none");
		}
		
		return builder.toString();
	}
	
	static final String dumpRegistrations()
	{
		SmartStringBuilder builder = new SmartStringBuilder();
		
		builder.appendln("Registered listener type to resources map:").tab();
		
		SetMultimap<Class<? extends Listener>, Resource<?>> map = Resources.registrations();
		
		SortedSet<Class<? extends Listener>> types = Sets.newTreeSet(Strings.toStringComparator());
		
		types.addAll(map.keySet());
		
		if (!map.isEmpty())
		{
			for (Class<? extends Listener> type: types)
			{
				builder.appendln(DebugListeners.toString(type)).tab();
	
				List<Resource<?>> resources = Lists.newArrayList(map.get(type));
				
				if (!resources.isEmpty())
				{
					Collections.sort(resources, Strings.toStringComparator());
					
					for (Resource<?> resource: resources)
					{
						builder.appendln(toString(resource));
					}
				}
				else
				{
					builder.appendln("none");
				}
				
				builder.untab();
			}
		}
		else
		{
			builder.appendln("none");
		}

		return builder.toString();
	}
}
