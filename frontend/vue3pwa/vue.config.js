const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  transpileDependencies: true,
});

module.exports = {
  devServer: {
    proxy: {
      "/api": {
        target: "http://k8b104.p.ssafy.io:8080/api", // 백엔드 API 서버 주소
        changeOrigin: true,
        pathRewrite: {
          "^/api": "",
        },
      },
    },
  },
};