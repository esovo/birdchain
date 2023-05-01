<template>
  <div id="birds">
    <div class="d-flex align-center flex-column pa-6">
      <v-btn-toggle
        v-model="toggle"
        color="green"
        width="100px"
        variant="outlined"
      >
        <v-btn value="ALL">전체</v-btn>
        <v-btn value="RE">지역절멸</v-btn>
        <v-btn value="CR">위급</v-btn>
        <v-btn value="EN">위기</v-btn>
        <v-btn value="VU">취약</v-btn>
        <v-btn value="NT">준위협</v-btn>
        <v-btn value="LC">관심대상</v-btn>
      </v-btn-toggle>
    </div>

    <div class="cardsection">
      <BirdsCard
        v-for="(bird, index) in filteredBirds"
        :key="index"
        :birdData="{ ...bird, img: require(`@/assets/img/${bird.img}`) }"
      ></BirdsCard>
    </div>
    <InfiniteLoading @infinite="load" />
  </div>
</template>

<script>
import BirdsCard from "@/components/birds/BirdsCard.vue";
import birds from "../assets/json/bird.json";

export default {
  name: "BirdsView",
  components: {
    BirdsCard,
  },
  data: () => ({
    toggle: "ALL",
  }),
  computed: {
    filteredBirds() {
      if (this.toggle === "ALL") {
        return birds;
      } else {
        return birds.filter((bird) => bird.국가적색목록 === this.toggle);
      }
    },
  },
};
</script>

<style>
.cardsection {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  flex-wrap: wrap;
  margin-right: 10vw;
  margin-left: 10vw;
}
</style>
