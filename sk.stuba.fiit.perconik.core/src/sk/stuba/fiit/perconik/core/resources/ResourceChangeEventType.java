package sk.stuba.fiit.perconik.core.resources;

import java.util.Set;
import org.eclipse.core.resources.IResourceChangeEvent;
import sk.stuba.fiit.perconik.core.utilities.IntegralConstant;
import sk.stuba.fiit.perconik.core.utilities.IntegralConstantSupport;

public enum ResourceChangeEventType implements IntegralConstant
{
	/**
	 * @see org.eclipse.core.resources.IResourceChangeEvent#POST_CHANGE
	 */
	POST_CHANGE(IResourceChangeEvent.POST_CHANGE),
	
	/**
	 * @see org.eclipse.core.resources.IResourceChangeEvent#PRE_CLOSE
	 */
	PRE_CLOSE(IResourceChangeEvent.PRE_CLOSE),

	/**
	 * @see org.eclipse.core.resources.IResourceChangeEvent#PRE_DELETE
	 */
	PRE_DELETE(IResourceChangeEvent.PRE_DELETE),

	/**
	 * @see org.eclipse.core.resources.IResourceChangeEvent#PRE_AUTO_BUILD
	 */
	@Deprecated
	@SuppressWarnings("deprecation")
	PRE_AUTO_BUILD(IResourceChangeEvent.PRE_AUTO_BUILD),
	
	/**
	 * @see org.eclipse.core.resources.IResourceChangeEvent#PRE_BUILD
	 */
	PRE_BUILD(IResourceChangeEvent.PRE_BUILD),

	/**
	 * @see org.eclipse.core.resources.IResourceChangeEvent#POST_AUTO_BUILD
	 */
	@Deprecated
	@SuppressWarnings("deprecation")
	POST_AUTO_BUILD(IResourceChangeEvent.POST_AUTO_BUILD),
	
	/**
	 * @see org.eclipse.core.resources.IResourceChangeEvent#POST_BUILD
	 */
	POST_BUILD(IResourceChangeEvent.POST_BUILD),
	
	/**
	 * @see org.eclipse.core.resources.IResourceChangeEvent#PRE_REFRESH
	 */
	PRE_REFRESH(IResourceChangeEvent.PRE_REFRESH);

	private static final IntegralConstantSupport<ResourceChangeEventType> integers = IntegralConstantSupport.of(ResourceChangeEventType.class);

	private final int value;
	
	private ResourceChangeEventType(final int value)
	{
		this.value = value;
	}
		
	public static final Set<Integer> valuesAsIntegers()
	{
		return integers.getIntegers();
	}

	public static final ResourceChangeEventType valueOf(final int value)
	{
		return integers.getConstant(value);
	}

	public final int getValue()
	{
		return this.value;
	}
}
