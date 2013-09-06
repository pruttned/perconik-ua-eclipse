package sk.stuba.fiit.perconik.utilities.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import com.google.common.annotations.Beta;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeToken;

@Beta
abstract class AbstractAccessor<T> implements Accessor<T>
{
	final TypeToken<T> token;
	
	AbstractAccessor(final TypeToken<T> token)
	{
		assert token != null;
		
		this.token = token;
	}
	
	static class ConstantAccessor<T> extends AbstractAccessor<T>
	{
		final T constant;
		
		ConstantAccessor(TypeToken<T> type, T constant)
		{
			super(type);
			
			this.constant = constant;
		}
		
		@Override
		public final T getFailing()
		{
			return this.constant;
		}
	}
	
	static class FieldAccessor<T> extends AbstractAccessor<T>
	{
		final Field field;
		
		FieldAccessor(TypeToken<T> type, Field field)
		{
			super(type);
			
			this.field = field;
		}
		
		@Override
		public final T getFailing() throws IllegalAccessException
		{
			return (T) this.token.getRawType().cast(this.field.get(null));
		}
	}
	
	static class InvokableAccessor<T> extends AbstractAccessor<T>
	{
		final Invokable<?, T> invokable;
		
		InvokableAccessor(TypeToken<T> type, Invokable<?, T> invokable)
		{
			super(type);
			
			this.invokable = invokable;
		}

		@Override
		public final T getFailing() throws IllegalAccessException, InvocationTargetException
		{
			return this.invokable.invoke(null);
		}
	}
	
	public final T get()
	{
		try
		{
			return this.getFailing();
		}
		catch (ReflectiveOperationException e)
		{
			throw new ReflectionException(e);
		}
	}
	
	abstract T getFailing() throws ReflectiveOperationException;
}
