<template>
<div>
        <div class="filter">

        </div>
        <a-divider>酒店详细介绍</a-divider>
        <span>{{detailstring}}</span>
        <a-divider></a-divider><a-divider></a-divider>
        <a-divider>热门评价</a-divider>
        <span v-for="item in activeUsers" :key="item.index">

            <a-divider></a-divider>
            评分：{{item.rate}}分
             <a-divider type="vertical" />
             <a-divider type="vertical" />
            <a-rate style="font-size: 15px" :value="item.rate"></a-rate>
             <a-divider type="vertical" />
             <a-divider type="vertical" />
            评价内容：{{item.comment}}
            <a-divider type="vertical" /><a-divider type="vertical" /><a-divider type="vertical" /><a-divider type="vertical" /><a-divider type="vertical" /><a-divider type="vertical" /><a-divider type="vertical" /><a-divider type="vertical" /><a-divider type="vertical" /><a-divider type="vertical" /><a-divider type="vertical" /><a-divider type="vertical" />
            {{item.checkOutDate}}

<a-divider></a-divider>
        </span>




</div>


</template>

<script>
    import { mapGetters, mapActions, mapMutations } from 'vuex'
    export default {
        name: 'hDetail',
        props:{
            detailstring:{},
            orderinfor:{}

        },
        computed: {
            activeUsers: function () {
                return this.orderinfor.filter(function (item) {

                    return item.orderState=='已评价';//返回isShow=true的项，添加到activeUsers数组
                })
            }
        }
        }



</script>

<style scoped>

</style>