package sk.stuba.fiit.perconik.debug.listeners;

import org.eclipse.core.commands.operations.OperationHistoryEvent;
import sk.stuba.fiit.perconik.core.listeners.OperationHistoryListener;
import sk.stuba.fiit.perconik.core.utilities.PluginConsole;
import sk.stuba.fiit.perconik.debug.Debug;

public final class OperationHistoryDebugListener extends AbstractDebugListener implements OperationHistoryListener
{
	public OperationHistoryDebugListener()
	{
	}
	
	public OperationHistoryDebugListener(final PluginConsole console)
	{
		super(console);
	}
	
	public final void historyNotification(final OperationHistoryEvent event)
	{
		this.print("Operation history:");
		this.printOperationHistoryEvent(event);
	}
	
	private final void printOperationHistoryEvent(final OperationHistoryEvent event)
	{
		this.put(Debug.dumpOperationHistoryEvent(event));
	}
}