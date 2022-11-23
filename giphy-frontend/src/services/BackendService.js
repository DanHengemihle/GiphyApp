import axios from 'axios';

const http = axios.create ({
    baseURL: "http://localhost:9000"
});

export default {
    getGiphys() {
        return http.get("/giphy?query=cats");
    },
    getGiphyBySearch(search){
        return http.get(`/giphy?query=${search}`);
    },
    getGiphyDetail(id){
        return http.get(`/detail/${id}`);
    },
    saveGiphy(giphy) {
        return http.post("/add", giphy);
    }
}