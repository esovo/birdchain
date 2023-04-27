<template lang="">
  <div class="flip-card">
    <div class="flip-card-inner">
      <div class="flip-card-front">
        <v-card
          class=""
          width="300"
          >
          <v-img
            :src=birdImgUrl
            height="200px"
            cover
          ></v-img>

          <v-card-title>
            새이름
          </v-card-title>

          <v-card-subtitle>
            
          </v-card-subtitle>
            내용

          <v-card-actions>
            <v-btn
              color="orange-lighten-2"
              variant="text"
            >
            자세히 보기
            </v-btn>

            <v-spacer></v-spacer>

          </v-card-actions>
        </v-card>
      </div>
      <div class="flip-card-back">
        <v-card
          class=""
          width="300"
          >
          <v-img
            :src=birdImgUrl
            height="200px"
            cover
          ></v-img>

          <v-card-title>
            새이름
          </v-card-title>

          <v-card-subtitle>
            
          </v-card-subtitle>
            어쩌구 저쩌구
        </v-card>
    </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "BirdsCard",
  data: () => ({
      show: false,
      birdImgUrl:  require("../../assets/img/owl.png"),
  }),
}
</script>
<style>
/* The flip card container - set the width and height to whatever you want. We have added the border property to demonstrate that the flip itself goes out of the box on hover (remove perspective if you don't want the 3D effect */
.flip-card {
  margin-top: 200px;
  margin-right: 2vw;
  margin-left: 2vw;
  background-color: transparent;
  width: 300px;
  height: 200px;
  perspective: 1000px; /* Remove this if you don't want the 3D effect */
}

/* This container is needed to position the front and back side */
.flip-card-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.8s;
  transform-style: preserve-3d;
}

/* Do an horizontal flip when you move the mouse over the flip box container */
.flip-card:active .flip-card-inner {
  
  transform: rotate3d(1, 1, 1, 45deg);
}

/* Position the front and back side */
.flip-card-front, .flip-card-back {
  position: absolute;
  width: 100%;
  height: 100%;
  -webkit-backface-visibility: hidden; /* Safari */
  backface-visibility: hidden;
}

/* Style the front side (fallback if image is missing) */
.flip-card-front {
  background-color: #bbb;
  color: black;
}

/* Style the back side */
.flip-card-back {
  background-color: dodgerblue;
  color: white;
  transform: rotateY(180deg);
}
</style>