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
    <div class="cardsection">
      <birds-card></birds-card>
      <birds-card></birds-card>
      <birds-card></birds-card>
    </div>
    <v-pagination :length="6" id="bird-pagination"></v-pagination>
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
<style>

.cardsection{
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-top: 100px;
  margin-right: 10vw;
  margin-left: 10vw;
}

#bird-pagination{
  margin-top: 200px;
}
</style>