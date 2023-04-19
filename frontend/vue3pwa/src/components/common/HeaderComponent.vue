<template>
  <div id="navbar">
      <img :src="LogoUrl" class="Logoimg"/>
      <div class="headerLink">
        <router-link to="/birds">멸종 위기 조류</router-link>
      </div>
      <div class="headerLink">
        <router-link to="/donation">기부하기</router-link>
      </div>
      <div class="headerLink">
        <router-link to="/infomation">정보 공유</router-link>
      </div>
      <div class="headerLink">
        <router-link to="/mypage">마이페이지</router-link>
      </div>
      <div class="walletimg">
        <img :src="walletUrl" />
      </div>
  </div>
  <br>
</template>

<script>

export default {
  name: 'HeaderComponent',
  data() {
    return {
      LogoUrl:  require("../../assets/img/Logo.png"),
      walletUrl:  require("../../assets/img/wallet.png")
    }
  }
}
</script>

<style>
#navbar {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  display: flex;
  flex-direction: row;
  font-size: 18;
  color: #4E4E4E;
  font-family: 'IBM Plex Sans KR';
  font-style: normal;
  font-weight: 400;
  line-height: 27px;
  width: 100%;
  border-bottom: solid;
  background-color: white;
}
a {
  text-decoration: none;
  color: #4E4E4E;
}

.Logoimg{
  height: 100px;
}

.walletimg{
  flex : 1;
  display: flex;
  align-self: center;
  justify-content: flex-end; 
  height: 30px;
  margin-right: 20px;
}

.headerLink{
  display: flex;
  flex-direction: row;
  margin-left: 4%;
  margin-top: 40px;
}

@media (max-width: 600px) {  
    
    #navbar {  
      flex-wrap: wrap;  
      flex-direction: column;
      justify-content: center;
      border-bottom: solid;
    } 
    .Logoimg{
      width: 80%;
    }
      
    .headerLink {  
      flex-basis: 50%;  
      margin-left: 4%;
      margin-top: 10px;
    }
    .walletimg img{
      display: flex;
      align-self: center;
      justify-content: flex-end; 
      width: 30px;
      margin-right: 20px;
    }
  
  }
</style>