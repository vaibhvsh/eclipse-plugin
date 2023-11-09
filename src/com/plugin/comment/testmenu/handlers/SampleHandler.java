
// TODO: add exceptions for different file types - DONE
// TODO: create a accept/reject dialog box for comment - DONE
// TODO: get highlighted text inside a variable from the test environment editor - DONE

package com.plugin.comment.testmenu.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.viewers.ISelection;

public class SampleHandler extends AbstractHandler {
	MetaData meta = new MetaData();

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IWorkbenchPage page = window.getActivePage();
		IEditorPart editor = page.getActiveEditor();
		if (editor != null) {
			IEditorInput input = editor.getEditorInput();
			if (input instanceof FileEditorInput) {
				IPath path = ((FileEditorInput) input).getPath();
				String fileExtension = path.getFileExtension();
				if (fileExtension != null && fileExtension.equals("java")) {
					String comment = meta.DOCUMENTINFO;
					IDocumentProvider documentProvider = ((ITextEditor) editor).getDocumentProvider();
					IDocument document = documentProvider.getDocument(input);
					ITextViewer viewer = ((ITextEditor) editor).getAdapter(ITextViewer.class);
					if (document != null && viewer != null) {
						int offset = viewer.getTextWidget().getCaretOffset();
						ISelection selection = HandlerUtil.getCurrentSelection(event);
						if (selection instanceof ITextSelection) {
							ITextSelection textSelection = (ITextSelection) selection;
							IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
									.getActivePage().getActiveEditor();
							IDocumentProvider documentProvider1 = ((ITextEditor) editorPart).getDocumentProvider();
							IDocument document1 = documentProvider1.getDocument(editorPart.getEditorInput());
							String selectedText = textSelection.getText();
							System.out.println(selectedText);
							String replacementText = "/* This comment is generated from the selected text:\r\n"
									+ selectedText + " */"
											+ "\r\n"
											+ "\r\n";
							try {
								if (MessageDialog.openConfirm(window.getShell(), "Confirmation",
										"Do you want to add a comment?")) {
									document.replace(offset, 0, comment);
									document1.replace(textSelection.getOffset(), textSelection.getLength(),
											replacementText);
								} else {
									MessageDialog.openInformation(window.getShell(), "", "Comment not added");
								}
							} catch (BadLocationException e) {
								e.printStackTrace();
							}
						}
					}
				} else {
					MessageDialog.openWarning(window.getShell(), "Warning", "This is not a java file");
				}
			}
		} else {
			MessageDialog.openWarning(window.getShell(), "Warning", "This is works only in java editor");
		}

		return null;
	}
}
