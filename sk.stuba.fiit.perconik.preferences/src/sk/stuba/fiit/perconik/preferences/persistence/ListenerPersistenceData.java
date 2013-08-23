package sk.stuba.fiit.perconik.preferences.persistence;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import sk.stuba.fiit.perconik.core.Listener;
import sk.stuba.fiit.perconik.core.Listeners;
import com.google.common.base.Preconditions;

public final class ListenerPersistenceData implements Serializable
{
	// TODO
	
	private static final long serialVersionUID = -1672202405264953995L;

	private final transient boolean registered;
	
	private final transient Class<? extends Listener> type;
	
	private final transient Listener listener;

	ListenerPersistenceData(final boolean registered, final Class<? extends Listener> type, final Listener listener)
	{
		this.registered = registered;
		this.type       = checkType(type);
		this.listener   = listener instanceof Serializable ? listener : null;
		
		Preconditions.checkArgument(listener == null || type == this.listener.getClass());
	}
	
	public static final ListenerPersistenceData of(final Class<? extends Listener> type)
	{
		return new ListenerPersistenceData(Listeners.isRegistred(type), type, null);
	}
	
	public static final ListenerPersistenceData of(final Listener listener)
	{
		return new ListenerPersistenceData(Listeners.isRegistred(listener), listener.getClass(), listener);
	}
	
	static final Class<? extends Listener> checkType(final Class<? extends Listener> type)
	{
		Preconditions.checkArgument(Listener.class.isAssignableFrom(type));
		Preconditions.checkArgument(!type.isInterface() && !type.isAnnotation() && !type.isEnum());
		
		try
		{
			type.getConstructor();
		}
		catch (NoSuchMethodException | SecurityException e)
		{
			throw new IllegalArgumentException(e);
		}
		
		return type;
	}

	private static final class SerializationProxy implements Serializable
	{
		private static final long serialVersionUID = -6638506142325802066L;

		private final boolean registered;
		
		private final Class<? extends Listener> type;
		
		private final Listener listener;
		
		private SerializationProxy(final ListenerPersistenceData data)
		{
			this.registered = data.isRegistered();
			this.type       = data.getListenerClass();
			this.listener   = data.getSerializedListener();
		}
		
		static final SerializationProxy of(final ListenerPersistenceData data)
		{
			return new SerializationProxy(data);
		}
		
		private final Object readResolve() throws InvalidObjectException
		{
			try
			{
				return new ListenerPersistenceData(this.registered, this.type, this.listener);
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
		
		if (!(o instanceof ListenerPersistenceData))
		{
			return false;
		}

		ListenerPersistenceData other = (ListenerPersistenceData) o;

		return this.type == other.type;
	}

	@Override
	public final int hashCode()
	{
		return this.type.hashCode();
	}
	
	public final boolean isRegistered()
	{
		return this.registered;
	}

	public final boolean hasSerializedListener()
	{
		return this.listener != null;
	}
	
	public final Class<? extends Listener> getListenerClass()
	{
		return this.type;
	}

	public final Listener getSerializedListener()
	{
		return this.listener;
	}
}