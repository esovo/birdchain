import { createApp } from 'vue'
// import { createPinia } from 'pinia'
import App from './App.vue'
import './registerServiceWorker'
import router from './router/index.js'
import 'vuetify/styles'
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'

const vuetify = createVuetify({
  components,
  directives,
})

// App.use(createPinia())
const app = createApp(App)
// app.use(createPinia())
app.use(vuetify).use(router).mount('#app')







