<template>
    <div>
        <br>
        <br>
        商圈：“{{business(currentbigRegion)}}”的搜索结果:
        <a-divider></a-divider>
        <div class="hotelList">
            <a-layout>
                <a-layout-content style="min-width: 800px">
                    <a-spin :spinning="hotelListLoading">
                        <div class="card-wrapper">
                            <HotelCard :hotel="item" v-for="item in hotellistbybigRegion" :key="item.index" @click.native="jumpToDetails(item.id)"></HotelCard>
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
        name: "hotelsearchbybigregion",
        data() {
            return {
                hotellistbybigRegion:[],
            }
        },
        components: {
            HotelCard
        },
        computed: {
            ...mapGetters([
        'currentbigRegion',
                'hotelList',
                'hotelListLoading'
            ])
        },
        mounted() {
            this.set_currentbigRegion(String(this.$route.params.bigRegion))
            this.getHotellistbybigRegion()
        },
        beforeRouteUpdate(to, from, next) {
            this.set_currentbigRegion(String(to.params.bigRegion))

            this.getHotellistbybigRegion()
            next()
        },
        methods: {
            ...mapMutations([
                'set_currentbigRegion',
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
            getHotellistbybigRegion(){

                this.getHotelList()
                for(var i=0;i<this.hotelList.length;i++){

                    if (this.hotelList[i].bizRegion==this.currentbigRegion){
                        this.hotellistbybigRegion.push(this.hotelList[i])
                    }

                }
            },
            business(data){
                if(data=='XiDan'){return '西单';}
                if(data=='WanDa'){return '万达';}
                if(data=='XianLin'){return '仙林';}
                if(data=='GuLou'){return '鼓楼';}
                return '西单';
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