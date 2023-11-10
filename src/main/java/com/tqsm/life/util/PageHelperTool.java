package com.tqsm.life.util;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Title: PageHelperTool.java
 * @Package
 * @Description: 分页工具类
 */
public class PageHelperTool {
    /**
     * PageHelper中，如果当前页是最后一页，则返回的nextPage是0，即首页，而有时我们需要最后一页的nextPage是lastPage，因此写此方法
     *
     * @param currentPage
     * @param pageObj
     * @return
     */
    public static <T> PageInfo<T> lastPageSetNextPage(int currentPage, PageInfo<T> pageObj) {
        if (currentPage == pageObj.getPages()) {
            pageObj.setNextPage(pageObj.getPages());
        }
        return pageObj;
    }

    public static <T> PageInfo<T> initPageInfoObj(int currentPage, int total, int pageSize, PageInfo<T> pageInfo) {
        pageInfo.setNextPage(currentPage < ((total + pageSize - 1) / pageSize) ? currentPage + 1 : currentPage);
        pageInfo.setTotal(total);
        pageInfo.setPageNum(currentPage);
        pageInfo.setPages((total + pageSize - 1) / pageSize);
        //pageInfo.setLastPage((total + pageSize - 1) / pageSize);
        pageInfo.setPrePage(currentPage > 1 ? currentPage - 1 : currentPage);
        pageInfo.setIsFirstPage(currentPage == 1);
        pageInfo.setIsLastPage(currentPage == (total + pageSize - 1) / pageSize);
        pageInfo.setHasPreviousPage(currentPage != 1);
        pageInfo.setHasNextPage(currentPage != (total + pageSize - 1) / pageSize);
        return calcNavigatepageNums(pageInfo);
    }

    private static <T> PageInfo<T> calcNavigatepageNums(PageInfo<T> pageInfo) {
        // 当总页数小于或等于导航页码数时
        if (pageInfo.getPages() <= pageInfo.getNavigatePages()) {
            pageInfo.setNavigatepageNums(new int[pageInfo.getPages()]);
            for (int i = 0; i < pageInfo.getPages(); i++) {
                pageInfo.getNavigatepageNums()[i] = i + 1;
            }
        } else { // 当总页数大于导航页码数时
            pageInfo.setNavigatepageNums(new int[pageInfo.getNavigatePages()]);
            int startNum = pageInfo.getPageNum() - pageInfo.getNavigatePages() / 2;
            int endNum = pageInfo.getPageNum() + pageInfo.getNavigatePages() / 2;

            if (startNum < 1) {
                startNum = 1;
                // (最前navigatePages页
                for (int i = 0; i < pageInfo.getNavigatePages(); i++) {
                    pageInfo.getNavigatepageNums()[i] = startNum++;
                }
            } else if (endNum > pageInfo.getPages()) {
                endNum = pageInfo.getPages();
                // 最后navigatePages页
                for (int i = pageInfo.getNavigatePages() - 1; i >= 0; i--) {
                    pageInfo.getNavigatepageNums()[i] = endNum--;
                }
            } else {
                // 所有中间页
                for (int i = 0; i < pageInfo.getNavigatePages(); i++) {
                    pageInfo.getNavigatepageNums()[i] = startNum++;
                }
            }
        }
        return pageInfo;
    }

    public static <T> PageInfo<T> excutePageInfo(List<T> sourceList, int pageIndex, int pageSize)
    {
        if(CollectionUtils.isEmpty(sourceList))
        {
            return new PageInfo<>(sourceList);
        }
        int fromIndex = 0;
        int toIndex = 0;
        int total = sourceList.size(); // 取出总记录数
        if (total / pageSize == 0 && total % pageSize > 0) {
            toIndex = total;
        } else {
            if (total / pageSize >= 1) {
                fromIndex = pageSize * (pageIndex - 1);
                if (pageSize * pageIndex >= total) {
                    toIndex = total;
                } else {
                    toIndex = pageSize * pageIndex;
                }
            }
        }
        //做pn越界处理

        try {
            sourceList =sourceList.subList(fromIndex, toIndex);
        } catch (IndexOutOfBoundsException e) {
            fromIndex = 0;
            toIndex= pageSize;
            sourceList =sourceList.subList(fromIndex, toIndex);
        }catch(IllegalArgumentException e) {
            fromIndex = total-pageSize;
            toIndex =total;
            sourceList =sourceList.subList(fromIndex, toIndex);
        }

        PageInfo<T> page = new PageInfo<T>(sourceList, 7);
        page = PageHelperTool.initPageInfoObj(pageIndex, total, pageSize, page);  //调用分页工具
        return page;
    }

}