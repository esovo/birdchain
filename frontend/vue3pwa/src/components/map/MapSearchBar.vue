<template>
  <div>
   <v-toolbar
      dense
      floating
    >
      <v-text-field
        hide-details
        prepend-icon="search"
        single-line
        v-model="keyword"
        @keyup.enter="sendAddress"
      >
      <font-awesome-icon :icon="['fasl', 'magnifying-glass']" size="xl" class="search-icon"/>
      </v-text-field>
      <v-btn icon>
        <font-awesome-icon :icon="['fasl', 'location-crosshairs']" size="xl" style="color: #838486;" />
      </v-btn>
    </v-toolbar>
  </div>
</template>

<script setup>
import { defineEmits, ref } from "vue";

const emit = defineEmits(["searchByAddress"]);
const keyword = ref(null);

const sendAddress = () => {
  emit("searchByAddress", keyword.value);
  keyword.value = null;
}

</script>

<style scoped>
.search-icon {
  color: #838486;
  padding-right: 15px;
}
</style>