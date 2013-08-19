package sk.stuba.fiit.perconik.core.resources;

import org.eclipse.ui.IWorkbenchWindow;
import sk.stuba.fiit.perconik.core.listeners.PerspectiveListener;
import sk.stuba.fiit.perconik.core.listeners.WindowListener;

final class PerspectiveHook extends InternalHook<IWorkbenchWindow, PerspectiveListener> implements WindowListener
{
	PerspectiveHook(final PerspectiveListener listener)
	{
		super(new InternalWindowHandler(listener));
	}
	
	static final class Support extends AbstractHookSupport<PerspectiveHook, IWorkbenchWindow, PerspectiveListener>
	{
		public final Hook<IWorkbenchWindow, PerspectiveListener> create(final PerspectiveListener listener)
		{
			return new PerspectiveHook(listener);
		}
	}

	private static final class InternalWindowHandler extends InternalHandler<IWorkbenchWindow, PerspectiveListener>
	{
		InternalWindowHandler(final PerspectiveListener listener)
		{
			super(listener);
		}

		public final void register(final IWorkbenchWindow window)
		{
			window.addPerspectiveListener(this.listener);
		}

		public final void unregister(final IWorkbenchWindow window)
		{
			window.removePerspectiveListener(this.listener);
		}
	}
	
	@Override
	final void preRegisterInternal()
	{
		Hooks.addWindowsSynchronouslyTo(this);
	}
	
	public final void windowOpened(final IWorkbenchWindow window)
	{
		this.add(window);
	}

	public final void windowClosed(final IWorkbenchWindow window)
	{
		this.remove(window);
	}

	public final void windowActivated(final IWorkbenchWindow window)
	{
	}

	public final void windowDeactivated(final IWorkbenchWindow window)
	{
	}
}