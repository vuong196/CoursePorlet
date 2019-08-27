<%@include file="/html/courselist/init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/html/courselist/view_search.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
	<portlet:param name="mvcPath" value="/html/courselist/view.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<liferay-ui:header
		backURL="<%= viewURL.toString() %>"
		title="search"
	/>

	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" />
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<%
	SearchContext searchContext = SearchContextFactory.getInstance(request);

	searchContext.setKeywords(keywords);
        searchContext.setAttribute("paginationType", "more");
        searchContext.setStart(0);
        searchContext.setEnd(10);
        
        Indexer indexer = IndexerRegistryUtil.getIndexer(Entry.class);

        Hits hits = indexer.search(searchContext);
        
        List<Entry> entries = new ArrayList<Entry>();

        for (int i = 0; i < hits.getDocs().length; i++) {
                Document doc = hits.doc(i);

                long entryId = GetterUtil
                .getLong(doc.get(Field.ENTRY_CLASS_PK));

                Entry entry = null;
                
                try {
                        entry = EntryLocalServiceUtil.getEntry(entryId);
                } catch (PortalException pe) {
                        _log.error(pe.getLocalizedMessage());
                } catch (SystemException se) {
                        _log.error(se.getLocalizedMessage());
                }
                
                entries.add(entry);
        }

        List<Guestbook> guestbooks = GuestbookLocalServiceUtil.getGuestbooks(scopeGroupId);
        
        Map<String, String> guestbookMap = new HashMap<String, String>();
        
        for (Guestbook guestbook : guestbooks) {
                guestbookMap.put(Long.toString(guestbook.getGuestbookId()), guestbook.getName());
        }
%>