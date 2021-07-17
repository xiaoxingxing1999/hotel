<template>
    <a-modal
            :visible="addCouponVisible"
            title="添加优惠策略"
            cancelText="取消"
            okText="确定"
            @cancel="cancel"
            @ok="handleSubmit"
    >
        <!-- 这里是添加策略模态框区域，请编写表单 -->
        <a-form :form="form" style="margin-top: 30px" v-bind="formItemLayout">
            <a-form-item label="优惠券类型" v-bind="formItemLayout">
                <a-select v-decorator="['type',{rules: [{required:true,message: '请选择类型'}]}]"
                          @change="changeType"
                >

                    <a-select-option value="2">多间特惠</a-select-option>
                    <a-select-option value="3">满减特惠</a-select-option>
                    <a-select-option value="4">限时特惠</a-select-option>
                </a-select>
            </a-form-item>
            <a-form-item label="券名" v-bind="formItemLayout">
                <a-input
                        placeholder="请填写优惠券名"
                        v-decorator="['name',{rules: [{required:true,message:'请输入券名'}]}]"
                />
            </a-form-item>

            <!-- 多间优惠实现-->
            <a-form-item label="折扣" v-bind="formItemLayout" v-if="this.form.getFieldValue('type')==='2'">
                <a-input placeholder="请填写三间以上折扣"
                         v-decorator="['discount',{rules:[{required:true,message:'请填写具体折扣'}]}]"
                />
            </a-form-item>

            <!-- 满减优惠实现-->
            <a-form-item label="达标金额" v-if="this.form.getFieldValue('type')==='3'">
                <a-input placeholder="请填写达标金额"
                         v-decorator="['targetMoney',{rules:[{required:true,message:'请填写达标金额'}]}]"
                />
            </a-form-item>
            <a-form-item label="优惠金额" v-bind="formItemLayout" v-if="this.form.getFieldValue('type')==='3'">
                <a-input placeholder="请填写优惠金额"
                         v-decorator="['discountMoney',{rules:[{required:true,message:'请填写优惠金额'}]}]"
                />
            </a-form-item>

            <!-- 限时优惠实现-->
            <a-form-item label="折扣" v-bind="formItemLayout" v-if="this.form.getFieldValue('type')==='4'">
                <a-input placeholder="请填写折扣"
                         v-decorator="['discount',{rules:[{required:true,message:'请填写折扣'}]}]"
                />
            </a-form-item>

            <a-form-item label="起始-失效时间" v-if="this.form.getFieldValue('type')==='4'">
                <ARangePicker
                        :format="format"
                        showTime
                        onChange={onChange}
                        v-decorator="['time',{rules: [{required:true,message: '请选择时间'}]}]"
                />
            </a-form-item>



            <a-form-item label="优惠简介" v-bind="formItemLayout">
                <a-input type="textarea" :rows="4" placeholder="请填写优惠简介"
                         v-decorator="['description',{rules: [{required:true,message:'请填写优惠简介'}]}]"
                />
            </a-form-item>
        </a-form>
    </a-modal>
</template>
<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
export default {
    name: 'addCouponModal',
    data() {
        return {
            formItemLayout: {
                labelCol: {
                    xs: { span: 12 },
                    sm: { span: 6 },
                },
                wrapperCol: {
                    xs: { span: 24 },
                    sm: { span: 16 },
                },
            },
        }
    },
    computed: {
        ...mapGetters([
            'activeHotelId',
            'addCouponVisible',
        ])
    },
    beforeCreate() {
        // 表单名默认为“form”
        this.form = this.$form.createForm(this, { name: 'addCouponModal' });
    },
    mounted() {

    },
    methods: {
        ...mapMutations([
            'set_addCouponVisible'
        ]),
        ...mapActions([
            // addHotelCoupon：添加酒店策略接口
            // actions this.$store.dispatch (xxx )   mapActions
            'addHotelTargetRoomCoupon',
            'addHotelTargetMoneyCoupon',
            'addHotelTargetTimeCoupon'
        ]),
        cancel() {
            this.set_addCouponVisible(false)
        },
        changeType(v){
            if( v == '3') {

            }else{
                //this.$message.warning('请实现')
            }
        },
        handleSubmit(e) {
            e.preventDefault();
            this.form.validateFieldsAndScroll((err, values) => {
                if (!err) {
                    //多间优惠
                    if(this.form.getFieldValue('type')==='2'){
                        const data = {
                            name: this.form.getFieldValue('name'),
                            description: this.form.getFieldValue('description'),
                            type: Number(this.form.getFieldValue('type')),
                            discount: Number(this.form.getFieldValue('discount')),
                            hotelId: Number(this.activeHotelId),
                            status: 1
                        }
                        this.addHotelTargetRoomCoupon(data)
                        this.form.resetFields()

                    }
                    else if(this.form.getFieldValue('type')==='3') {
                        const data = {
                            // 这里添加接口参数
                            name: this.form.getFieldValue('name'),
                            description: this.form.getFieldValue('description'),
                            type: Number(this.form.getFieldValue('type')),
                            targetMoney: Number(this.form.getFieldValue('targetMoney')),
                            discountMoney: Number(this.form.getFieldValue('discountMoney')),
                            hotelId: Number(this.activeHotelId),
                            status: 1,
                        }
                        this.addHotelTargetMoneyCoupon(data)
                        this.form.resetFields()

                    }
                    else if(this.form.getFieldValue('type')==='4'){
                        const data = {
                            name: this.form.getFieldValue('name'),
                            description: this.form.getFieldValue('description'),
                            type: Number(this.form.getFieldValue('type')),
                            startTime: this.form.getFieldValue('time')[0],
                            endTime: this.form.getFieldValue('time')[1],
                            discount: Number(this.form.getFieldValue('discount')),
                            hotelId: Number(this.activeHotelId),
                            status: 1
                        }
                        this.addHotelTargetTimeCoupon(data)
                        this.form.resetFields()
                    }
                }
            });
        },//响应按钮的按下，调用action方法
    }
}
</script>