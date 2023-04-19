import { createApp } from 'vue'
// import { createPinia } from 'pinia'
import App from './App.vue'
import './registerServiceWorker'
import router from './router/index.js'

// App.use(createPinia())
const app = createApp(App)
// app.use(createPinia())
app.use(router).mount('#app')







