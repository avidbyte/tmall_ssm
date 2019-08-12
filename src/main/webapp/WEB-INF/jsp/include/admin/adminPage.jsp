<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>

	
<script>
$(function(){
	$("ul.pagination li.disabled a").click(function(){
		return false;
	});
});

</script>


<nav>
  <ul class="pagination">
    <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
      <a  href="?offset=0${page.param}" aria-label="Previous" >
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>

    <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
      <a  href="?offset=${page.offset-page.limit}${page.param}" aria-label="Previous" >
        <span aria-hidden="true">&lsaquo;</span>
      </a>
    </li>    

    <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
    
    	
		    <li <c:if test="${status.index*page.limit==page.offset}">class="disabled"</c:if>>
		    	<a  
		    	href="?offset=${status.index*page.limit}${page.param}"
		    	<c:if test="${status.index*page.limit==page.offset}">class="current"</c:if>
		    	>${status.count}</a>
		    </li>
		
    </c:forEach>

    <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
      <a href="?offset=${page.offset+page.limit}${page.param}" aria-label="Next">
        <span aria-hidden="true">&rsaquo;</span>
      </a>
    </li>
    <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
      <a href="?offset=${page.last}${page.param}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
