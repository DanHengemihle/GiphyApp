<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link :to="{name: 'About'}">About</router-link> |
      <router-link :to="{name: 'Giphy'}">Giphy</router-link>
    </div>
    <router-view/>
  </div>
</template>

<script>
import backendService from './services/BackendService.js';
  export default {
    created() {
      // call the backend
        // - BackendService -- create  -- done
        // - method that gets the giphys from the backend -- done
      backendService.getGiphys()
      .then((response) => {
        // console.log(response);
      // load the giphys into the store
        // -  commit a mutation
        // - means write the giphys to the store
        this.$store.commit("SET_GIPHYS", response.data);
      });
    }
  }
</script>


<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
