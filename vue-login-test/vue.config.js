module.exports = {
  devServer: {
    proxy: {
      '/login': {
        target: 'http://localhost:8085',
        changeOrigin: true
      }
    }
  }
};
