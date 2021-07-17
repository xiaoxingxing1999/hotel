<template>
    <div class="info-wrapper">
        <a-tabs>
            <a-tab-pane tab="我的信息" key="1">
                <a-form :form="form" style="margin-top: 30px">
                    
                    <a-form-item label="用户名" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1  }">
                        <a-input
                            placeholder="请填写用户名"
                            v-decorator="['userName', { rules: [{ required: true, message: '请输入用户名' }] }]"
                            v-if="modify"
                        />
                        <span v-else>{{ userInfo.userName }}</span>
                    </a-form-item>
                    <a-form-item label="邮箱" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1 }">
                        <span>{{ userInfo.email }}</span>
                    </a-form-item>
                    
                    <a-form-item label="手机号" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1 }">
                        <a-input
                            placeholder="请填写手机号"
                            v-decorator="['phoneNumber', { rules: [{ required: true, message: '请输入手机号' }] }]"
                            v-if="modify"
                        />
                        <span v-else>{{ userInfo.phoneNumber}}</span>
                    </a-form-item>
                    <a-form-item label="信用值" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1 }">
                        <span>{{ userInfo.credit }}</span>
                    </a-form-item>
                    <a-form-item label="密码" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1 }" v-if="modify">
                        <a-input
                            placeholder="请输入新密码"
                            v-decorator="['password', { rules: [{ required: true, message: '请输入新密码' }] }]"
                        />
                    </a-form-item>
                    <a-form-item :wrapper-col="{ span: 12, offset: 5 }" v-if="modify">
                        <a-button type="primary" @click="saveModify">
                            保存
                        </a-button>
                        <a-button type="default" style="margin-left: 30px" @click="cancelModify">
                            取消
                        </a-button>
                    </a-form-item>
                     <a-form-item :wrapper-col="{ span: 8, offset: 4 }" v-else>
                        <a-button type="primary" @click="modifyInfo">
                            修改信息
                        </a-button>
                    </a-form-item>
                </a-form>
            </a-tab-pane>
            <a-tab-pane tab="我的订单" key="2">
                <a-table
                    :columns="columns"
                    :dataSource="userOrderList"
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
                    <a-tag slot="orderState" color="blue" slot-scope="text">
                        {{ text }}
                    </a-tag>
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





                        <a-divider type="vertical" v-if="record.orderState == '已预订'"></a-divider>
                        <a-popconfirm
                            title="你确定撤销该笔订单吗？"
                            @confirm="confirmCancelOrder(record.id)"
                            @cancel="cancelCancelOrder"
                            okText="确定"
                            cancelText="取消"
                            v-if="record.orderState == '已预订'&&getannulflag(record.checkInDate)"

                        >
                            <a-button type="danger" size="small" v-if="getannulflag(record.checkInDate)">撤销</a-button>
                        </a-popconfirm>
                        <a-divider type="vertical" ></a-divider>




                            <a-button type="primary" size="small" @click="showCommentDetails(record.id)" v-if="record.orderState == '已入住'">评价</a-button>


                       <a-modal title="订单评价" :visible="commentVisible&&(currentIndex===record.id)"
                                @cancel="cancelComment" :footer="null">

                            <a-descriptions bordered :column="{ xxl: 4, xl: 3, lg: 3, md: 3, sm: 2, xs: 1 }" layout="vertical" >
                                <a-descriptions-item  label="订单打星评分" >
                                 <Addstar></Addstar>
                                </a-descriptions-item>

                                <a-descriptions-item label="文字评论">
                                    <a-textarea v-model="incomment"></a-textarea>
                                </a-descriptions-item>
                            </a-descriptions>

                           <a-button type="primary" class="conf" @click="commitcomment(record)">提交</a-button>

                        </a-modal>




                    </span>
                </a-table>
            </a-tab-pane>
        </a-tabs>
    </div>
</template>

<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
import Addstar from './star'
const columns = [
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
        title: '状态',
        filters: [{ text: '已预订', value: '已预订' }, { text: '已入住', value: '已入住' },{ text: '已评价', value: '已评价' },{ text: '已撤销', value: '已撤销' },{ text: '酒店撤销', value: '酒店撤销' } ],
        onFilter: (value, record) => record.orderState.includes(value),
        dataIndex: 'orderState',
        scopedSlots: { customRender: 'orderState' }
    },
    {
      title: '操作',
      key: 'action',
      scopedSlots: { customRender: 'action' },
    },


  ];
export default {
    name: 'info',
    data(){
        return {
            commentVisible: false,
            contentVisible:false,
            currentIndex: '',
            modify: false,
            formLayout: 'horizontal',
            pagination: {},
            columns,
            data: [],
            form: this.$form.createForm(this, { name: 'coordinated' }),
            incomment:'',
            scr:0,

        }
    },
    components: {
        Addstar,
    },
    computed: {
        ...mapGetters([
            'userId',
            'userInfo',
            'userOrderList',
            'idOrder',
            'hasaddcredit'
        ])
    },
    async mounted() {
        await this.getUserInfo()
        await this.getUserOrders()
    },
    methods: {
        ...mapActions([
            'getUserInfo',
            'getUserOrders',
            'getOrderById',
            'updateUserInfo',
            'cancelOrder',
            'addOrderRate',
            'addOrderComment',
            'addcredit',
            'getHotelRate',
            'sethasaddcredit',
            'gethasaddcredit',
            'changeStatus',
        ]),
        ...mapMutations([
            'set_comment',
            'set_currentIndex',
            'set_hasaddcredit'

        ]),
        getannulflag(checkindate){
            var cindate=parseInt(checkindate.substring(0,4)+checkindate.substring(5,7)+checkindate.substring(8,10))
            var today;
            var date=new Date();
            if (date.getDate()<10){today=parseInt(date.getFullYear().toString()+"0"+(date.getMonth()+1).toString()+"0"+date.getDate().toString())}
            else {
                today = parseInt(date.getFullYear().toString() + "0" + (date.getMonth() + 1).toString() + date.getDate().toString())
            }

            if(today>=cindate){return false}
            return true

        },
        showCommentDetails(recordid){
            this.commentVisible=true
            this.currentIndex=recordid
            this.set_currentIndex(this.currentIndex)
            this.gethasaddcredit(recordid)     //5

        },

        commitcomment(record){
            this.set_comment(this.incomment)
            this.commentVisible=false
            this.incomment=''
            this.scr=0
            this.addOrderRate()
            this.addOrderComment()
            this.change(record.id,'已评价')

            if (this.hasaddcredit == 0) {//8

                this.addcredit(record.id);       //9
                this.sethasaddcredit(record.id);}  //15
               this.set_hasaddcredit(0)          //16


            this.getHotelRate(record.id)
            location.reload(true)
        },
        change(orderid,status){
            const data={
                orderid:orderid,
                status:status
            }
            this.changeStatus(data)
        },

        showOrderDetails(recordid){
            this.contentVisible=true
            this.currentIndex=recordid
            this.getOrderById(recordid)
        },
        cancelContent(){
            this.contentVisible=false
        },
        saveModify() {
            this.form.validateFields((err, values) => {
                if (!err) {
                    const data = {
                        userName: this.form.getFieldValue('userName'),
                        phoneNumber: this.form.getFieldValue('phoneNumber'),
                        password: this.form.getFieldValue('password')
                    }
                    this.updateUserInfo(data).then(()=>{
                        this.modify = false
                    })
                }
            });
        },
        modifyInfo() {
            setTimeout(() => {
                this.form.setFieldsValue({
                    'userName': this.userInfo.userName,
                    'phoneNumber': this.userInfo.phoneNumber,
                })
            }, 0)
            this.modify = true
        },
        cancelModify() {
            this.modify = false
        },
        cancelComment(){
            this.commentVisible=false
        },
        confirmCancelOrder(orderId){
            this.cancelOrder(orderId)
        },
        cancelCancelOrder() {

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
    .info-wrapper {
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
    .info-wrapper {
        .ant-tabs-bar {
            padding-left: 30px
        }
    }
</style>
<style lang="less">

</style>


<style>@import "../../../src/static/star.css";</style>