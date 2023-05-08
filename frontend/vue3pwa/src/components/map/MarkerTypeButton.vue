<template>
  <div class="mapbutton">
    <v-btn-toggle
      v-model="toggle_multiple"
      color="light-green lighten-2"
      multiple
      variant="outlined"
      divided
    >
      <v-btn value="birdstrike">
        버드<br>스트라이크
      </v-btn>
        <v-btn value="birdappear">
          새발견
        </v-btn>
      </v-btn-toggle>
  </div>
   
</template>
<script>
  export default {
    data: () => ({
      toggle_multiple: [],
    }),
  }
</script>

<style scoped>
.mapbutton{
  margin-top: 30px;
  margin-bottom: 30px;
}

.v-btn-group--density-default.v-btn-group{
  position:relative;
  left: 30%;

}

@media (max-width: 600px) {
  .v-btn {
    width: 80px;
  }
  .v-btn-group--density-default.v-btn-group{
  position:relative;
  left: 23vw;
  }
}
</style>
