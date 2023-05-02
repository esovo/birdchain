<template>
  <v-col
    cols="6"
    sm="11"
    class="py-10 pr-16 text-right"
  >
    <v-btn-toggle
      v-model="toggle_multiple"
      color="light-green lighten-2"
      multiple
      variant="outlined"
      divided
    >
      <v-btn value="birdstrike">
        버드스트라이크
      </v-btn>

      <v-btn value="birdappear">
        새발견
      </v-btn>
    </v-btn-toggle>
  </v-col>
</template>
<script>
  export default {
    data: () => ({
      toggle_multiple: [],
    }),
    mounted() {
      console.log(this.toggle_multiple);
    }
  }
</script>
