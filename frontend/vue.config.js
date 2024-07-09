const { defineConfig } = require('@vue/cli-service');
const webpack = require('webpack');

module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: '../src/main/resources/static', // Build Directory
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:9090',
        changeOrigin: true,
      }
    }
  },
  configureWebpack: {
    plugins: [
      new webpack.DefinePlugin({
        '__VUE_PROD_HYDRATION_MISMATCH_DETAILS__': JSON.stringify(false)
      })
    ]
  }
});