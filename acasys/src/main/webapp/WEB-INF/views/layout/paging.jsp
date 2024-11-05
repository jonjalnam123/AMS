<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 페이징 스타일링을 위한 CSS -->
<style>
    /* 페이징 컨테이너 */
    .paging-container {
        display: flex;
        justify-content: center;
        margin-top: 20px; /* 위쪽 여백도 줄임 */
        width: 100%;
    }

    /* 페이징 리스트 스타일 */
    .pagination {
        list-style: none;
        padding: 0;
        margin: 0;
        display: flex;
        justify-content: center;
        width: 100%;
    }

    /* 페이지 항목 */
    .pagination .page-item {
        margin: 0 3px; /* 항목 간의 여백 조정 */
    }

    /* 페이지 링크 스타일 */
    .pagination .page-link {
        display: inline-block;
        padding: 4px 8px; /* 크기를 더 작게 조정 */
        text-decoration: none;
        color: #007bff;
        background-color: #fff; 
        border: 1px solid #ddd;
        border-radius: 5px;
        font-size: 10px; /* 작은 글꼴 */
        text-align: center;
        width: 20px; /* 고정 너비로 버튼 크기 설정 */
        height: 20px; /* 고정 높이 */
        line-height: 20px; /* 텍스트 수평 정렬 */
        transition: all 0.3s ease;
    }

    /* 호버 효과 */
    .pagination .page-item a:hover {
        background-color: #f0f0f0;
        border-color: #ccc;
        cursor: pointer;
    }

    /* 활성화된 페이지 스타일 */
    .pagination .page-item.active .page-link {
        background-color: #007bff;
        border-color: #007bff;
        color: white;
        font-weight: bold;
    }

    /* 비활성화된 페이지 링크 */
    .pagination .page-item.disabled .page-link {
        background-color: #e9ecef;
        border-color: #e9ecef;
        color: #6c757d;
    }

    /* 첫 번째 페이지, 끝 페이지 스타일 */
    .pagination .first, .pagination .last {
        font-weight: bold;
    }

    /* 이전, 다음 버튼 크기 */
    .pagination .prev, .pagination .next {
        font-size: 14px; /* 글꼴 크기 줄임 */
        width: 24px; /* 이전/다음 버튼 크기 조정 */
        height: 24px;
        line-height: 24px;
    }
</style>

<!-- 페이징 UI 구현 -->
<div class="paging-container">
    <ul class="pagination">

        <!-- 이전 페이지로 가기 (항상 노출, 비활성화 가능) -->
        <li class="page-item <c:if test="${paging.curPage == 1}">disabled</c:if>">
            <a class="page-link" href="/student/acasysStudetnList.do?curPage=${paging.curPage - 1 }">&lt;</a>
        </li>

        <!-- 페이징 리스트 -->
        <c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="i">
            <c:if test="${paging.curPage eq i }">
                <li class="page-item active">
                    <span class="page-link">${i}</span>
                </li>
            </c:if>
            <c:if test="${paging.curPage ne i }">
                <li class="page-item">
                    <a class="page-link" href="/student/acasysStudetnList.do?curPage=${i }">${i}</a>
                </li>
            </c:if>
        </c:forEach>

        <!-- 다음 페이지로 가기 (항상 노출, 비활성화 가능) -->
        <li class="page-item <c:if test="${paging.curPage == paging.totalPage}">disabled</c:if>">
            <a class="page-link" href="/student/acasysStudetnList.do?curPage=${paging.curPage + 1 }">&gt;</a>
        </li>

    </ul>
</div>