package com.wxx.rxmodule.bean;

import java.util.List;

/**
 * 作者: Tangren on 2017-10-23
 * 包名：com.wxx.rxmodule.bean
 * 邮箱：996489865@qq.com
 * TODO:一句话描述
 */

public class WaresList {

    /**
     * copyright : 本API接口只允许菜鸟窝(http://www.cniao5.com)用户使用,其他机构或者个人使用均为侵权行为
     * totalCount : 17
     * currentPage : 2
     * totalPage : 0
     * pageSize : 10
     * orders : []
     * list : [{"id":148,"categoryId":2,"campaignId":5,"name":"丹杰仕2015 新款韩版男士商务休闲西装 夜店礼服 发型师西服套装男 46黑色 西服+裤子  M","imgUrl":"http://m.360buyimg.com/n4/jfs/t2452/143/380009338/90400/895e2bcc/5605640fN26350d9f.jpg!q70.jpg","price":438,"sale":5480},{"id":150,"categoryId":2,"campaignId":2,"name":"丹杰仕 韩版修身男士西服商务休闲西装套装三件套职业装新郎结婚礼服 卡其色(单件外套) XL","imgUrl":"http://m.360buyimg.com/n4/jfs/t2413/194/273873867/120999/5c51ed4/55fc0bbdN04e882c8.jpg!q70.jpg","price":268,"sale":1250},{"id":151,"categoryId":2,"campaignId":1,"name":"宜佳来正品专柜西服厚款秋冬款西服套装男黑色西装套装商务正装西服工装职业装结婚礼服上班应聘 黑色两扣227 175/72C","imgUrl":"http://m.360buyimg.com/n4/jfs/t2155/131/586641151/199723/482a04e6/561b92ffN2fde06d4.jpg!q70.jpg","price":368,"sale":7637},{"id":153,"categoryId":2,"campaignId":1,"name":"雅戈尔 YOUNGOR 2014新款经典黑色提花超修身版套西服 E034 黑色 175/96A  (N)","imgUrl":"http://m.360buyimg.com/n4/jfs/t1450/349/123052584/60686/1a63637b/555d49beN3897de7c.jpg!q70.jpg","price":1258,"sale":9259},{"id":154,"categoryId":2,"campaignId":14,"name":"丹杰仕2015秋季男装外套个性潮男士小西装修身花西服男韩版休闲西装 咖色(单件套) XL","imgUrl":"http://m.360buyimg.com/n4/jfs/t1714/18/951150841/184549/b94acbd9/55dc5cbeN540b71a4.jpg!q70.jpg","price":268,"sale":2991},{"id":155,"categoryId":2,"campaignId":1,"name":"丹杰仕 男士西服套装小西服韩版外套英伦修身时尚花纹西装套装 单件西服 XL","imgUrl":"http://m.360buyimg.com/n4/jfs/t1345/78/800716712/165502/a84c939e/55dc64a8N79003ed7.jpg!q70.jpg","price":268,"sale":7181},{"id":156,"categoryId":2,"campaignId":7,"name":"丹杰仕2105年秋冬季节新款 男士修身西服套装男士三件套装 20酒红色西服加裤子两件套 L110-125斤左右","imgUrl":"http://m.360buyimg.com/n4/jfs/t1699/111/1450442764/178940/66ce1e48/55cabe5dN9e040df7.jpg!q70.jpg","price":428,"sale":6931}]
     */

    private String copyright;
    private int totalCount;
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private List<?> orders;
    private List<ListBean> list;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<?> getOrders() {
        return orders;
    }

    public void setOrders(List<?> orders) {
        this.orders = orders;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 148
         * categoryId : 2
         * campaignId : 5
         * name : 丹杰仕2015 新款韩版男士商务休闲西装 夜店礼服 发型师西服套装男 46黑色 西服+裤子  M
         * imgUrl : http://m.360buyimg.com/n4/jfs/t2452/143/380009338/90400/895e2bcc/5605640fN26350d9f.jpg!q70.jpg
         * price : 438
         * sale : 5480
         */

        private int id;
        private int categoryId;
        private int campaignId;
        private String name;
        private String imgUrl;
        private int price;
        private int sale;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public int getCampaignId() {
            return campaignId;
        }

        public void setCampaignId(int campaignId) {
            this.campaignId = campaignId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSale() {
            return sale;
        }

        public void setSale(int sale) {
            this.sale = sale;
        }

        @Override
        public String toString() {
            return "ListBean{" +
                    "id=" + id +
                    ", categoryId=" + categoryId +
                    ", campaignId=" + campaignId +
                    ", name='" + name + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", price=" + price +
                    ", sale=" + sale +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WaresList{" +
                "copyright='" + copyright + '\'' +
                ", totalCount=" + totalCount +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", orders=" + orders +
                ", list=" + list +
                '}';
    }
}
