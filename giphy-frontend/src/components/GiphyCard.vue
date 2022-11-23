<template>
  <div id="card" v-on:click="viewGiphyDetail(giphy.id)">
      <h2>{{ giphy.title }}</h2>
      <img :src="giphy.url" alt="giphy image" />
  </div>
</template>

<script>
export default {
    name: "giphy-card",
    props: {
        giphy: Object,
    },
    methods: {
        viewGiphyDetail(giphyId){
            this.$router.push(`/giphy/${giphyId}`);
            // this.$router.push("/giphy/" + giphyId);
        }
    }
}
</script>

<style scoped>
#card {
    border: 2px solid black;
    border-radius: 5px;
    width: 250px;
    margin: 20px;
}
#card > img {
    height: 200px;
    max-width: 200px;
}
</style>