import { axios } from '@/utils/request'
const api = {
    couponPre: '/api/coupon'
}
export function hotelTargetMoneyAPI(data) {
    return axios({
        url: `${api.couponPre}/hotelTargetMoney`,
        method: 'POST',
        data,
    })//POST请求添加满减优惠
}

export function hotelTargetTimeAPI(data) {
    return axios({
        url: `${api.couponPre}/hotelTargetTime`,
        method: 'POST',
        data,
    })//POST请求添加限时优惠
}

export function hotelTargetRoomAPI(data) {
    return axios({
        url: `${api.couponPre}/hotelTargetRoom`,
        method: 'POST',
        data,
    })//POST请求添加限时优惠
}

export function hotelAllCouponsAPI(hotelId) {
    return axios({
        url: `${api.couponPre}/hotelAllCoupons`,
        method: 'GET',
        params: {hotelId: hotelId},
    })
}

export function orderMatchCouponsAPI(params) {
    return axios({
        url: `${api.couponPre}/orderMatchCoupons`,
        method: 'GET',
        params,
    })
}
export function deleteCouponAPI(params) {
    return axios({
        url: `${api.couponPre}/${params}/deleteCoupon`,
        method: 'GET',
    })
}