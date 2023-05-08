<template>
  <div id="home">
    <div id="mainComponent1">
      <img :src="img1" id="img1" />
      <div class="textfield">
        <div class="maintext">
          멸종위기에 처한<br />
          새들을 위해 기부하세요.
        </div>
        <div class="subtext">
          새는 매우 중요한 생태계의 일원입니다.<br />
          새의 멸종은 식량 연쇄 반응과 함께 <br />
          다른 동물과 식물들도 영향을 받을 수 있습니다.
        </div>
      </div>
    </div>
    <div id="mainComponent2">
      <img :src="LogoUrl" id="img2" />
    </div>
    <div id="mainComponent3">
      <img :src="LogoUrl" id="img3" />
    </div>
    <div class="nftdonator"></div>
  </div>
</template>

<script>
export default {
  name: "HomeView",
  data() {
    return {
      img1: require("../assets/img/image 14.png"),
    };
  },
};
</script>

<style>
#home {
  display: flex;
  flex-direction: column;
  margin-right: 10%;
  margin-top: 10%;
}

#mainComponent1 {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.textfield {
  display: flex;
  flex-direction: column;
}

.maintext {
  font-family: "IBM Plex Sans";
  font-style: normal;
  font-weight: 600;
  font-size: 64px;
  text-align: right;
  text-transform: capitalize;
  color: #02100d;
}

.subtext {
  font-family: "IBM Plex Sans";
  font-style: normal;
  font-weight: 400;
  font-size: 20px;
  text-align: right;
  text-transform: capitalize;

  color: #444444;
}
</style>
