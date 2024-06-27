<template>
    <div class="container-fluid">
        <img src="@/assets/img/MenuMateLogo.png" alt="MenuMate 로고" class="logo">
        <div class="pageNameBar">
            <span class="pageName">MenuMate</span>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Home',
}
</script>

<style>
.container-fluid {
    display:flex;

    padding: 20px 10px;
    border-bottom: 5px solid red;
    width: 100vw;
    margin: 0
}

.logo {
    padding: 0;
    height: 100px;
    width: 100px;

}

.pageNameBar {
    display: flex;
    /* Flexbox 설정 */
}

.pageName {
    margin: 0;
    font-size: 50px;
    font-family: '명품굴림';
}
</style>