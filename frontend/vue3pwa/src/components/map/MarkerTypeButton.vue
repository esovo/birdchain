<template>
  <v-col
    cols="6"
    sm="12"
    class="py-2"
  >
    <v-btn-toggle
      v-model="toggle_multiple"
      background-color="primary"
      dark
      multiple
    >
      <v-btn>
        버드스트라이크
      </v-btn>

      <v-btn>
        새발견
      </v-btn>
    </v-btn-toggle>
  </v-col>
</template>
<script>
  export default {
    data: () => ({
      toggle_multiple: [0,1],
    }),
  }
</script>