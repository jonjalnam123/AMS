<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    /* 좌측 메뉴 전체 스타일 */
    .left-menu {
        width: 250px;
        background-color: #28a745; /* 초록색 배경 */
        height: 100%;
        margin-top: 50px;
        position: fixed;
        top: 0;
        left: 0;
        padding-top: 20px;
        display: flex;
        flex-direction: column;
        justify-content: flex-start;
    }

    /* 메뉴 리스트 스타일 */
    .menu-list {
        list-style: none;
        padding: 0;
        margin: 0;
        flex-grow: 1;
    }

    /* 각 메뉴 항목 스타일 */
    .menu-item {
        margin: 12px 0;
        padding: 0;
        background-color: transparent; /* 배경색을 없앰 */
        transition: transform 0.3s ease; /* 크기 변화 효과 */
    }

    /* 메뉴 버튼 기본 스타일 */
    .menu-btn {
        width: 100%;
        padding: 14px 20px;
        border: none;
        border-radius: 5px;
        color: white;
        font-size: 16px;
        font-weight: 500;
        cursor: pointer;
        text-align: left;
        background-color: transparent; /* 배경색 없앰 */
        transition: color 0.3s, transform 0.2s ease; /* 텍스트 색상만 변화 */
        box-sizing: border-box; /* 패딩과 테두리를 포함한 크기 계산 */
    }

    /* 메뉴 버튼 hover 시 스타일 */
    .menu-btn:hover {
        color: #e0e0e0; /* hover 시 글자 색상 */
        transform: scale(1.05); /* hover 시 살짝 커지도록 */
    }

    .menu-btn:focus {
        outline: none;
    }

    /* 버튼 내부 링크 스타일 */
    .menu-btn a {
        text-decoration: none;
        color: inherit; /* 링크 색상을 버튼 색상으로 상속 */
    }

    /* 반응형 디자인: 모바일 대응 */
    @media (max-width: 768px) {
        .left-menu {
            width: 200px; /* 모바일 화면에서는 조금 더 좁게 */
        }

        .menu-btn {
            font-size: 14px;
        }
    }

</style>
<script type="text/javascript">
$(document).ready(function() {
    // 추가 JavaScript 코드가 필요하면 여기에 작성
});
</script>

<div class="left-menu">
    <!-- 메뉴 항목 리스트 -->
    <ul class="menu-list">
        <li class="menu-item">
            <a href="/student/acasysStudetnList.do">
                <button type="button" class="menu-btn">학생/성적 관리</button>
            </a>
        </li>
        <li class="menu-item">
            <a href="/student/acasysStudentRegist.do">
                <button type="button" class="menu-btn">학생등록</button>
            </a>
        </li>
    </ul>
</div>