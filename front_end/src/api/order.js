import { axios } from '@/utils/request'
const api = {
    orderPre: '/api/order'
}
export function reserveHotelAPI(data) {
    return axios({
        url: `${api.orderPre}/addOrder`,
        method: 'POST',
        data,
    })
}
export function getAllOrdersAPI() {
    return axios({
        url: `${api.orderPre}/getAllOrders`,
        method: 'GET',
    })
}
export function getHotelOrdersAPI(hotelId) {
    return axios({
        url: `${api.orderPre}/${hotelId}/allOrders`,
        method: 'GET',
    })
}
export function getUserOrdersAPI(data) {
    return axios({
        url: `${api.orderPre}/${data.userId}/getUserOrders`,
        method: 'GET',
    })
}
export function cancelOrderAPI(orderId) {
    return axios({
        url: `${api.orderPre}/${orderId}/annulOrder`,
        method: 'GET',
    })
}
export function deleteOrderAPI(orderId) {
    return axios({
        url: `${api.orderPre}/${orderId}/deleteOrder`,
        method: 'GET',
    })
}
export function addOrderRateAPI(orderId,rate) {
    return axios({
        url: `${api.orderPre}/${orderId}/${rate}/addOrderRate`,
        method: 'GET',
    })
}
export function addOrderCommentAPI(orderId,comment) {
    return axios({
        url: `${api.orderPre}/${orderId}/${comment}/addOrderComment`,
        method: 'GET',
    })
}
export function getOrderAPI(orderid) {
    return axios({
        url: `${api.orderPre}/${orderid}/getOrder`,
        method: 'GET'
    })
}
export function changeStatusAPI(data) {
    return axios({
        url: `${api.orderPre}/${data.orderid}/${data.status}/changeStatus`,
        method: 'GET'
    })
}
export function sethasaddcreditAPI(data) {
return axios({
    url: `${api.orderPre}/${data}/sethasaddcredit`,
    method: 'GET'
})
}
export function gethasaddcreditAPI(data) {
    return axios({
        url: `${api.orderPre}/${data}/gethasaddcredit`,
        method: 'GET'
    })
}