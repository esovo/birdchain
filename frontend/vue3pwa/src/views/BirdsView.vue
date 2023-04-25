<template lang="">
  <div id="birds">
    <div class="d-flex align-center flex-column  pa-6">
    <v-btn-toggle
      v-model="toggle"
      color="green"
      width="100px"
      variant="outlined"
    >
      <v-btn >위급</v-btn>
      <v-btn >위기</v-btn>
      <v-btn >취약</v-btn>
      <v-btn >준위협</v-btn>
      <v-btn >최소관심</v-btn>
    </v-btn-toggle>
    </div>
    <!-- <div class="cardsection">
    </div> -->
    <!-- <v-pagination :length="6" id="bird-pagination"></v-pagination> -->
  <div class="cardsection" v-for="comment in comments" :key="comment.id">
    <birds-card></birds-card>
    <birds-card></birds-card>
    <birds-card></birds-card>
  </div>
  <InfiniteLoading @infinite="load" />
  
  </div>
</template>
<script>
import BirdsCard from '@/components/birds/BirdsCard.vue';

export default {
  name: 'BirdsView',
  components:{
    BirdsCard
  },
  data: () => ({
      toggle: null,
  }),

}
</script>


<script setup>
  import { ref } from "vue";
  import InfiniteLoading from "v3-infinite-loading";
  import "v3-infinite-loading/lib/style.css";
  import dummy from  "../assets/dummy/birdlist.json"
  let comments = ref([]);
  // let page = 1;
  const load = async $state => {
    console.log("loading...");

    try {
      // const response = await fetch(
      //   "https://jsonplaceholder.typicode.com/comments?_limit=10&_page=" + page
      // );
      const json = dummy
      console.log(json)
      if (json.length < 10) $state.complete();
      else {
        comments.value.push(...json);
        $state.loaded();
      }
      // page++;
    } catch (error) {
      $state.error();
    }
  };
</script>

<style>

.cardsection{
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  flex-wrap: wrap;
  margin-right: 10vw;
  margin-left: 10vw;
}

#bird-pagination{
  margin-top: 200px;
}

</style>