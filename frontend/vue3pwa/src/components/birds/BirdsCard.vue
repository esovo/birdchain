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
      <div class="overlay">
        <h2>Check This <span>Out!</span></h2>
        <p>this is some text.</p>
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
<style lang="scss">
/* The flip card container - set the width and height to whatever you want. We have added the border property to demonstrate that the flip itself goes out of the box on hover (remove perspective if you don't want the 3D effect */
// .flip-card {
//   margin-top: 200px;
//   margin-right: 2vw;
//   margin-left: 2vw;
//   background-color: transparent;
//   width: 300px;
//   height: 200px;
//   perspective: 1000px; /* Remove this if you don't want the 3D effect */
// }

// /* This container is needed to position the front and back side */
// .flip-card-inner {
//   position: relative;
//   width: 100%;
//   height: 100%;
//   text-align: center;
//   transition: transform 0.8s;
//   transform-style: preserve-3d;
// }

// /* Do an horizontal flip when you move the mouse over the flip box container */
// .flip-card:active .flip-card-inner {
//   -webkit-filter: blur(2px);
//   filter: blur(2px);
//   /* transform: rotate3d(1, 1, 1, 45deg); */
//   transition: .3s all;
//   opacity: 1;
// }

// /* Position the front and back side */
// .flip-card-front, .flip-card-back {
//   position: absolute;
//   width: 100%;
//   height: 100%;
//   -webkit-backface-visibility: hidden; /* Safari */
//   backface-visibility: hidden;
// }

// /* Style the front side (fallback if image is missing) */
// .flip-card-front {
//   background-color: #bbb;
//   color: black;
// }

// /* Style the back side */
// .flip-card-back {
//   background-color: dodgerblue;
//   color: white;
//   transform: rotateY(180deg);
// }

$flip-card: rgba(0, 0, 0, 0.2);

*,
*:before,
*:after {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}


.flip-card,
.overlay {
  text-align: center;
}

img,
.overlay {
  transition: .3s all;
  border-radius: 3px;
}

.flip-card {
  margin-top: 100px;
  margin-right: 2vw;
  margin-left: 2vw;
  float: left;
  max-width: 31%;
  position: relative;
  img {
    width: 100%;
    margin-bottom: -4px;
  }
  .overlay {
    position: absolute;
    top: 0;
    left: 0;
    bottom: 0;
    width: 100%;
    background: $flip-card;
    color: #fff;
    opacity: 0;
    h2 {
      padding-top: 20%;
      font-family: 'Droid Serif', serif;
    }
    p {
      font-family: 'Julius Sans One', sans-serif;
    }
  }
  &:active {
    .overlay {
      opacity: 1;
    }
    img {
      -webkit-filter: blur(2px);
      filter: blur(2px);
    }
  }
}
</style>