package sk.stuba.fiit.perconik.core.services;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import sk.stuba.fiit.perconik.core.plugin.Activator;
import sk.stuba.fiit.perconik.utilities.SmartStringBuilder;
import sk.stuba.fiit.perconik.utilities.MoreStrings;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

public abstract class AbstractService extends com.google.common.util.concurrent.AbstractService implements Service
{
	protected AbstractService()
	{
	}

	protected final static void failure(final Throwable cause, final String format, final Object ... args)
	{
		failure(cause, String.format(format, args));
	}

	protected final static void failure(final Throwable cause, final String message)
	{
		Activator.getDefault().getConsole().error(message, cause);
	}
	
	protected final void checkState(final State first, final State ... rest)
	{
		this.checkState(EnumSet.of(first, rest));
	}
	
	protected final void checkState(final Set<State> states)
	{
		if (!states.contains(this.state()))
		{
			SmartStringBuilder builder = new SmartStringBuilder();
			
			builder.append(this.toString()).append(" must be in state ");

			Function<State, String> toLowerCase = new Function<State, String>()
			{
				public final String apply(@Nonnull final State state)
				{
					return state.toString().toLowerCase();
				}
			};
			
			List<State> list = Lists.newArrayList(states);
			
			Collections.sort(list, MoreStrings.toStringComparator());

			builder.list(Lists.transform(list, toLowerCase));
			
			throw new IllegalStateException(builder.toString());
		}
	}
	
	protected final void checkRunning()
	{
		this.checkState(State.RUNNING);
	}
	
	@Override
	public final String toString()
	{
		return this.getName() + " [" + this.state().toString().toLowerCase() + "]";
	}

	public final String getName()
	{
		return this.getClass().getName();
	}
}
