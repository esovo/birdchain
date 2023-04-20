<template lang="">
  <div id="birds">
    <div class="d-flex align-center flex-column  pa-6">
    <v-btn-toggle
      v-model="toggle"
      color="green"
      variant="text"
      rounded="xl"
    >
      <v-btn >위급</v-btn>
      <v-btn >위기</v-btn>
      <v-btn >취약</v-btn>
      <v-btn >준위협</v-btn>
      <v-btn >최소관심</v-btn>
    </v-btn-toggle>
    </div>
    <birds-card></birds-card>
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
<style lang="">
  
</style>