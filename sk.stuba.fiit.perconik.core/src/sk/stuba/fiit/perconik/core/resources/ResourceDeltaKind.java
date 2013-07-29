package sk.stuba.fiit.perconik.core.resources;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import org.eclipse.core.resources.IResourceDelta;
import sk.stuba.fiit.perconik.core.utilities.IntegralConstant;
import sk.stuba.fiit.perconik.core.utilities.IntegralConstantSupport;

public enum ResourceDeltaKind implements IntegralConstant
{
	/**
	 * @see org.eclipse.core.resources.IResourceDelta#NO_CHANGE
	 */
	NO_CHANGE(IResourceDelta.NO_CHANGE),
	
	/**
	 * @see org.eclipse.core.resources.IResourceDelta#ADDED
	 */
	ADDED(IResourceDelta.ADDED),
	
	/**
	 * @see org.eclipse.core.resources.IResourceDelta#REMOVED
	 */
	REMOVED(IResourceDelta.REMOVED),
	
	/**
	 * @see org.eclipse.core.resources.IResourceDelta#CHANGED
	 */
	CHANGED(IResourceDelta.CHANGED),
	
	/**
	 * @see org.eclipse.core.resources.IResourceDelta#ADDED_PHANTOM
	 */
	ADDED_PHANTOM(IResourceDelta.ADDED_PHANTOM),
	
	/**
	 * @see org.eclipse.core.resources.IResourceDelta#REMOVED_PHANTOM
	 */
	REMOVED_PHANTOM(IResourceDelta.REMOVED_PHANTOM);
	
	public static final Set<ResourceDeltaKind> ALL_WITH_PHANTOMS = Collections.unmodifiableSet(EnumSet.of(CHANGED, ADDED, REMOVED, ADDED_PHANTOM, REMOVED_PHANTOM));
	
	private static final IntegralConstantSupport<ResourceDeltaKind> integers = IntegralConstantSupport.of(ResourceDeltaKind.class);

	private final int value;
	
	private ResourceDeltaKind(final int value)
	{
		this.value = value;
	}
	
	public static final Set<Integer> valuesAsIntegers()
	{
		return integers.getIntegers();
	}
	
	public static final ResourceDeltaKind valueOf(final int value)
	{
		return integers.getConstant(value);
	}

	public final int getValue()
	{
		return this.value;
	}
}
