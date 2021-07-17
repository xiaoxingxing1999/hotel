<template>
    <div class="manageHotel-wrapper">
        <a-tabs>
            <a-tab-pane tab="酒店管理" key="1">
                <div style="width: 100%; text-align: right; margin:20px 0">
                    <a-button type="primary" @click="addHotel"><a-icon type="plus" />添加酒店</a-button>
                </div>
                 <a-table
                    :columns="columns1"
                    :dataSource="hotelList"
                    bordered
                >
                    <span slot="action" slot-scope="record">
                        <a-button type="primary" size="small" @click="addRoom(record)">录入房间</a-button>
                        <a-divider type="vertical"></a-divider>
                        <a-button type="info" size="small" @click="showCoupon(record)">优惠策略</a-button>
                        <a-divider type="vertical"></a-divider>
                        <a-popconfirm
                            title="确定想删除该酒店吗？"
                            @confirm="deleteHotel(record)"
                            okText="确定"
                            cancelText="取消"
                        >
                            <a-button type="danger" size="small">删除酒店</a-button>
                        </a-popconfirm>
                    </span>
                </a-table>
            </a-tab-pane>
            <a-tab-pane tab="订单管理" key="2">
                <a-table
                    :columns="columns2"
                    :dataSource="orderList"
                    bordered
                >
                    <span slot="price" slot-scope="text">
                        <span>￥{{ text }}</span>
                    </span>
                    <span slot="roomType" slot-scope="text">
                        <span v-if="text == 'BigBed'">大床房</span>
                        <span v-if="text == 'DoubleBed'">双床房</span>
                        <span v-if="text == 'Family'">家庭房</span>
                    </span>
                    <span slot="action" slot-scope="record">


                        <a-button type="primary" size="small" @click="showOrderDetails(record.id)">订单详情</a-button>
                        <a-modal title="订单详情" :visible="contentVisible&&(currentIndex===record.id)"
                                 @cancel="cancelContent" :footer="null">
                            <a-descriptions  bordered :column="{ xxl: 4, xl: 3, lg: 3, md: 3, sm: 2, xs: 1 }" layout="vertical">
                                <a-descriptions-item label="订单号">
                                    {{idOrder.id}}
                                </a-descriptions-item>
                                <a-descriptions-item label="酒店名称">
                                    {{idOrder.hotelName}}
                                </a-descriptions-item>
                                <a-descriptions-item label="入住时间">
                                    {{idOrder.checkInDate}}
                                </a-descriptions-item>
                                <a-descriptions-item label="退房时间">
                                    {{idOrder.checkOutDate}}
                                </a-descriptions-item>
                                <a-descriptions-item label="房间类型">
                                    {{roomChange(idOrder.roomType)}}
                                </a-descriptions-item>
                                <a-descriptions-item label="房间数量">
                                    {{idOrder.roomNum}}
                                </a-descriptions-item>
                                <a-descriptions-item label="入住人数">
                                    {{idOrder.peopleNum}}
                                </a-descriptions-item>
                                <a-descriptions-item label="是否携带孩童">
                                    {{trueOrFalse(idOrder.haveChild)}}
                                </a-descriptions-item>
                                <a-descriptions-item label="价格">
                                    {{idOrder.price}}
                                </a-descriptions-item>
                                <a-descriptions-item label="客户名称">
                                    {{idOrder.clientName}}
                                </a-descriptions-item>
                                <a-descriptions-item label="手机号">
                                    {{idOrder.phoneNumber}}
                                </a-descriptions-item>
                                <a-descriptions-item label="订单状态">
                                    {{idOrder.orderState}}
                                </a-descriptions-item>
                                <a-descriptions-item label="顾客评分" >
                                    {{idOrder.rate}}
                                </a-descriptions-item>
                                <a-descriptions-item label="顾客评语" >
                                    {{idOrder.comment}}
                                </a-descriptions-item>
                            </a-descriptions>
                        </a-modal>


                        <a-divider type="vertical"></a-divider>
                        <!--<a-popconfirm
                            title="确定想删除该订单吗？"
                            @confirm="deleteOrder(record)"
                            okText="确定"
                            cancelText="取消"
                        >
                            <a-button type="danger" size="small">删除订单</a-button>
                        </a-popconfirm>-->

                        <a-popover title="订单管理" trigger="click" >
                            <a slot="content"
                               @click="change(record.id,'已预定')">
                                <a-tag>已预定</a-tag>
                            </a>
                            <a slot="content"
                               @click="change(record.id,'已入住')">
                                <a-tag>已入住</a-tag>
                            </a>
                            <a slot="content"
                               @click="change(record.id,'已评价')">
                                <a-tag>已评价</a-tag>
                            </a>
                            <a slot="content"
                               @click="change(record.id,'酒店撤销')">
                                <a-tag>撤销</a-tag>
                            </a>
                            <a slot="content" @click="deleteOrder(record)">
                                <a-tag>删除订单</a-tag>
                            </a>
                            <a-button type="primary" size="small"
                                      @click="manage">订单管理
                            </a-button>
                        </a-popover>


                    </span>
                </a-table>
            </a-tab-pane>
            
        </a-tabs>
        <AddHotelModal></AddHotelModal>
        <AddRoomModal></AddRoomModal>
        <Coupon></Coupon>
    </div>
</template>
<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
import AddHotelModal from './components/addHotelModal'
import AddRoomModal from './components/addRoomModal'
import Coupon from './components/coupon'
const moment = require('moment')
const columns1 = [
    {  
        title: '酒店名',
        dataIndex: 'name',
    },
    {
        title: '商圈',
        dataIndex: 'bizRegion',
    },
    {
        title: '地址',
        dataIndex: 'address',
    },
    {
        title: '酒店星级',
        dataIndex: 'hotelStar'
    },
    {
        title: '评分',
        dataIndex: 'rate',
    },
    {
        title: '简介',
        dataIndex: 'description',
    },
    {
      title: '操作',
      key: 'action',
      scopedSlots: { customRender: 'action' },
    },
  ];
const columns2 = [
    {  
        title: '订单号',
        dataIndex: 'id',
    },
    {  
        title: '酒店名',
        dataIndex: 'hotelName',
    },
    {
        title: '房型',
        dataIndex: 'roomType',
        scopedSlots: { customRender: 'roomType' }
    },
    {
        title: '入住时间',
        dataIndex: 'checkInDate',
        scopedSlots: { customRender: 'checkInDate' }
    },
    {
        title: '离店时间',
        dataIndex: 'checkOutDate',
        scopedSlots: { customRender: 'checkOutDate' }
    },
    {
        title: '入住人数',
        dataIndex: 'peopleNum',
    },
    {
        title: '房价',
        dataIndex: 'price',
    },
    {
      title: '操作',
      key: 'action',
      scopedSlots: { customRender: 'action' },
    },
  ];
export default {
    name: 'manageHotel',
    data(){
        return {
            contentVisible:false,
            currentIndex:0,
            formLayout: 'horizontal',
            pagination: {},
            columns1,
            columns2,
            form: this.$form.createForm(this, { name: 'manageHotel' }),
        }
    },
    components: {
        AddHotelModal,
        AddRoomModal,
        Coupon,
    },
    computed: {
        ...mapGetters([
            'orderList',
            'hotelList',
            'addHotelModalVisible',
            'addRoomModalVisible',
            'activeHotelId',
            'couponVisible',
            'idOrder'
        ]),
    },
    async mounted() {
        await this.getHotelList()
        await this.getAllOrders()
    },
    methods: {
        ...mapMutations([
            'set_addHotelModalVisible',
            'set_addRoomModalVisible',
            'set_couponVisible',
            'set_activeHotelId',
            'set_activeOrderId',
        ]),
        ...mapActions([
            'getHotelList',
            'getAllOrders',
            'getHotelCoupon',
            'DdeleteHotel',
            'DdeleteOrder',
            'getOrderById',
            'changeStatus',
        ]),
        addHotel() {
            this.set_addHotelModalVisible(true)
        },
        addRoom(record) {
            this.set_activeHotelId(record.id)
            this.set_addRoomModalVisible(true)
        },
        showCoupon(record) {
            this.set_activeHotelId(record.id)
            this.set_couponVisible(true)
            this.getHotelCoupon()
        },
        deleteHotel(record){
            this.set_activeHotelId(record.id)
            this.DdeleteHotel()
        },
        deleteOrder(record){
            this.set_activeOrderId(record.id)
            this.DdeleteOrder()
        },
        cancelContent(){
            this.contentVisible=false
        },
        showOrderDetails(recordid){
            this.contentVisible=true
            this.currentIndex=recordid
            this.getOrderById(recordid)
        },
        manage(index,item){
            for (const key in this.$refs) {
                if (key.indexOf('popover-') !== -1) {
                    this.$refs[key].doClose();
                }
            }
        },
        change(orderid,status){
            const data={
                orderid:orderid,
                status:status
            }
            this.changeStatus(data)
        },
        roomChange(name){
            if(name=="BigBed")
                return "大床房";
            else if(name=="DoubleBed")
                return "双床房";
            else if(name=="Family")
                return "家庭房";
            else
                return "无";
        },
        trueOrFalse(bool){
            if(bool)
                return "是";
            else
                return "否";
        }
    }
}
</script>
<style scoped lang="less">
    .manageHotel-wrapper {
        padding: 50px;
        .chart {
            display: flex;
            align-items: center;
            justify-content: space-between;
            margin-top: 20px
        }
    }
</style>
<style lang="less">
    .manageHotel-wrapper {
        .ant-tabs-bar {
            padding-left: 30px
        }
    }
</style>
<style lang="less">
    
</style>