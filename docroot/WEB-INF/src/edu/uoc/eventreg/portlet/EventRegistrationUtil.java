package edu.uoc.eventreg.portlet;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;

public class EventRegistrationUtil {
	
	public static String getImageUrl (String dlFileEntryId, HttpServletRequest request) {
		
		ThemeDisplay themeDisplay=null;
		if (request != null) {
			themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		}
		
		long groupId = themeDisplay.getScopeGroupId();
		
		DLFileEntry fileEntry = null;
		try {
			fileEntry = com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil.getFileEntryByUuidAndGroupId(dlFileEntryId, groupId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		fileEntry = fileEntry.toEscapedModel();
		
		long fileEntryId = fileEntry.getFileEntryId();
		long folderId = fileEntry.getFolderId();
		String name = fileEntry.getName();
		String extension = fileEntry.getExtension();
		String title = fileEntry.getTitle();
		
		String fileUrl = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + groupId + "//" + folderId +  "//" + HttpUtil.encodeURL(HtmlUtil.unescape(title));
		
		return fileUrl;
	}
	
}
