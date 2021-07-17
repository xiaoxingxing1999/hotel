<template>
    <div>
        <br>
        <br>
        关键词：“{{currentsearch}}”的搜索结果:
        <a-divider></a-divider>
        <div class="hotelList">
            <a-layout>
                <a-layout-content style="min-width: 800px">
                    <a-spin :spinning="hotelListLoading">
                        <div class="card-wrapper">
                            <HotelCard :hotel="item" v-for="item in hotellistbyname" :key="item.index" @click.native="jumpToDetails(item.id)"></HotelCard>
                            <div v-for="item in emptyBox" :key="item.name" class="emptyBox ant-col-xs-7 ant-col-lg-5 ant-col-xxl-3">
                            </div>

                        </div>
                    </a-spin>
                </a-layout-content>
            </a-layout>
        </div>
    </div>
</template>

<script>
    import { mapGetters, mapActions, mapMutations } from 'vuex'
    import hotelList from "./hotelList";
    import HotelCard from './components/hotelCard'
    export default {
        name: "hotelsearchbyname",
        data() {
            return {
                hotellistbyname:[],
            }
        },
        components: {
            HotelCard
        },
        computed: {
            ...mapGetters([
                'currentsearch',
                'hotelList',
                'hotelListLoading'
            ])
        },
        mounted() {
            this.set_currentsearch(String(this.$route.params.hotelname))
            this.getHotellistbyname()
        },
        beforeRouteUpdate(to, from, next) {
            this.set_currentsearch(String(to.params.hotelname))

            this.getHotellistbyname()
            next()
        },
        methods: {
            ...mapMutations([
                'set_currentsearch',
                'getHotelList'

            ]),
            ...mapActions([

            ]),
            jumpToDetails(id){
                this.$router.push({ name: 'hotelDetail', params: { hotelId: id }})
            },
            pageChange(page, pageSize) {
                const data = {
                    pageNo: page - 1
                }
                this.set_hotelListParams(data)
                this.set_hotelListLoading(true)
                this.getHotelList()
            },
            getHotellistbyname(){

                this.getHotelList()
                for(var i=0;i<this.hotelList.length;i++){
                    if (this.hotelList[i].name.indexOf(this.currentsearch)>=0){
                        this.hotellistbyname.push(this.hotelList[i])
                    }
                }
            },
        }
    }
</script>

<style scoped lang="less">
    .hotelList {
        text-align: center;
        padding: -20px 0;
        .emptyBox {
            height: 0;
            margin: 10px 10px
        }
        .card-wrapper{
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
            flex-grow: 3;
            min-height: 800px
        }
        .card-wrapper .card-item {
            margin: 30px;
            position: relative;
            height: 188px;
        }
    }
</style>