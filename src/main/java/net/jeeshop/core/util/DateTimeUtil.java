package net.jeeshop.core.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;


public class DateTimeUtil {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);
    // 格式：年－月－日 小时：分钟：秒
    public static final String FORMAT_ONE = "yyyy-MM-dd HH:mm:ss";

    // 格式：年－月－日 小时：分钟
    public static final String FORMAT_TWO = "yyyy-MM-dd HH:mm";

    // 格式：年月日 小时分钟秒
    public static final String FORMAT_THREE = "yyyyMMdd-HHmmss";

    // 格式：年－月－日
    public static final String LONG_DATE_FORMAT = "yyyy-MM-dd";

    // 格式：年 月 日
    public static final String LONG_DATECHINESE_FORMAT = "yyyy年MM月dd日";

    // 格式：月－日
    public static final String SHORT_DATE_FORMAT = "MM-dd";

    // 格式：小时：分钟：秒
    public static final String LONG_TIME_FORMAT = "HH:mm:ss";

    //格式：年-月
    public static final String MONTG_DATE_FORMAT = "yyyy-MM";

    // 年的加减
    public static final int SUB_YEAR = Calendar.YEAR;

    // 月加减
    public static final int SUB_MONTH = Calendar.MONTH;

    // 天的加减
    public static final int SUB_DAY = Calendar.DATE;

    // 小时的加减
    public static final int SUB_HOUR = Calendar.HOUR;

    // 分钟的加减
    public static final int SUB_MINUTE = Calendar.MINUTE;

    // 秒的加减
    public static final int SUB_SECOND = Calendar.SECOND;

    static final String dayNames[] = {"星期日", "星期一", "星期二", "星期三", "星期四",
            "星期五", "星期六"};

    @SuppressWarnings("unused")
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    private static final long m = 60*1000L;//分
    private static final long hour = 3600*1000L;//小时
    private static final long day = 24*hour;//天
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public DateTimeUtil() {
    }

    /**
     * 把符合日期格式的字符串转换为日期类型
     *
     * @param dateStr
     * @return
     */
    public static Date stringtoDate(String dateStr, String format) {
        if(StringUtils.isBlank(dateStr)){
            return null;
        }
        Date d = null;
        SimpleDateFormat formater = new SimpleDateFormat(format);
        String[] tmp = dateStr.split(" +");
        if (tmp.length != 2) {
            dateStr = dateStr + " 00:00:00";
        }
        try {
            formater.setLenient(false);
            d = formater.parse(dateStr);
        } catch (Exception e) {
            d = null;
            e.printStackTrace();
            logger.error("日期转化出错");
        }
        return d;
    }

    /**
     * 把符合日期格式的字符串转换为日期类型
     */
    public static Date stringtoDate(String dateStr, String format,
                                    ParsePosition pos) {
        Date d = null;
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            formater.setLenient(false);
            d = formater.parse(dateStr, pos);
        } catch (Exception e) {
            d = null;
        }
        return d;
    }

    public static Date stringtoDate(String date) {
        String format = "yyyy-MM-dd HH:mm:ss";
        return stringtoDate(date, format);
    }

    /**
     * 把日期转换为字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date, String format) {
        String result = "";
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            result = formater.format(date);
        } catch (Exception e) {
            // log.error(e);
        }
        return result;
    }

    /**
     * 获取当前时间的指定格式
     *
     * @param format
     * @return
     */
    public static String getCurrDate(String format) {
        return dateToString(new Date(), format);
    }

    /**
     * @param dateStr
     * @param amount
     * @return
     */
    public static String dateSub(int dateKind, String dateStr, int amount) {
        Date date = stringtoDate(dateStr, FORMAT_ONE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(dateKind, amount);
        return dateToString(calendar.getTime(), FORMAT_ONE);
    }

    /**
     * 两个日期相减
     *
     * @param firstTime
     * @param secTime
     * @return 相减得到的秒数
     */
    public static long timeSub(String firstTime, String secTime) {
        long first = stringtoDate(firstTime, FORMAT_ONE).getTime();
        long second = stringtoDate(secTime, FORMAT_ONE).getTime();
        return (second - first) / 1000;
    }

    /**
     * 两个日期相减
     *
     * @param firstTime
     * @param secTime
     * @return 相减得到的秒数
     */
    public static long timeSubDate(Date firstTime, Date secTime) {
        long first = firstTime.getTime();
        long second = secTime.getTime();
        return (second - first) / 1000;
    }

    /**
     * 获得某月的天数
     *
     * @param year  int
     * @param month int
     * @return int
     */
    public static int getDaysOfMonth(String year, String month) {
        int days = 0;
        if (month.equals("1") || month.equals("3") || month.equals("5")
                || month.equals("7") || month.equals("8") || month.equals("10")
                || month.equals("12")) {
            days = 31;
        } else if (month.equals("4") || month.equals("6") || month.equals("9")
                || month.equals("11")) {
            days = 30;
        } else {
            if ((Integer.parseInt(year) % 4 == 0 && Integer.parseInt(year) % 100 != 0)
                    || Integer.parseInt(year) % 400 == 0) {
                days = 29;
            } else {
                days = 28;
            }
        }

        return days;
    }

    /**
     * 获取某年某月的天数
     *
     * @param year  int
     * @param month int 月份[1-12]
     * @return int
     */
    public static int getDaysOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获得当前日期
     *
     * @return int
     */
    public static int getToday() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获得当前月份
     *
     * @return int
     */
    public static int getToMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获得当前年份
     *
     * @return int
     */
    public static int getToYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 返回日期的天
     *
     * @param date Date
     * @return int
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 返回日期的年
     *
     * @param date Date
     * @return int
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 返回日期的月份，1-12
     *
     * @param date Date
     * @return int
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 计算两个日期相差的天数，如果date2 &gt; date1 返回正数，否则返回负数
     *
     * @param date1 Date
     * @param date2 Date
     * @return long
     */
    public static long dayDiff(Date date1, Date date2) {
        return (date2.getTime() - date1.getTime()) / 86400000;
    }

    /**
     * 如果前面日期大于后面的日期则true,否则false
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean compareDay(Date date1, Date date2) {
        if (date1.getTime() > date2.getTime()) {
            return true;
        }
        return false;
    }

    /**
     * 比较两个日期的年差
     *
     * @param before
     * @param after
     * @return
     */
    public static int yearDiff(String before, String after) {
        Date beforeDay = stringtoDate(before, LONG_DATE_FORMAT);
        Date afterDay = stringtoDate(after, LONG_DATE_FORMAT);
        return getYear(afterDay) - getYear(beforeDay);
    }

    /**
     * 比较指定日期与当前日期的差
     *
     * @param after
     * @return
     */
    public static int yearDiffCurr(String after) {
        Date beforeDay = new Date();
        Date afterDay = stringtoDate(after, LONG_DATE_FORMAT);
        return getYear(beforeDay) - getYear(afterDay);
    }

    /**
     * 比较指定日期与当前日期的差
     *
     * @param before
     * @return
     * @author chenyz
     */
    public static long dayDiffCurr(String before) {
        Date currDate = DateTimeUtil.stringtoDate(currDay(), LONG_DATE_FORMAT);
        Date beforeDate = stringtoDate(before, LONG_DATE_FORMAT);
        return (currDate.getTime() - beforeDate.getTime()) / 86400000;

    }

    /**
     * 获取每月的第一周
     *
     * @param year
     * @param month
     * @return
     * @author chenyz
     */
    public static int getFirstWeekdayOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.SATURDAY); // 星期天为第一天
        c.set(year, month - 1, 1);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取每月的最后一周
     *
     * @param year
     * @param month
     * @return
     * @author chenyz
     */
    public static int getLastWeekdayOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.SATURDAY); // 星期天为第一天
        c.set(year, month - 1, getDaysOfMonth(year, month));
        return c.get(Calendar.DAY_OF_WEEK);
    }


    /**
     * 获得当前日期字符串，格式"yyyy-MM-dd HH:mm:ss"
     *
     * @return
     */
    public static String getNow() {
        Calendar today = Calendar.getInstance();
        return dateToString(today.getTime(), FORMAT_ONE);
    }

    /**
     * 根据生日获取星座
     *
     * @param birth YYYY-mm-dd
     * @return
     */
    public static String getAstro(String birth) {
        if (!isDate(birth)) {
            birth = "2000" + birth;
        }
        if (!isDate(birth)) {
            return "";
        }
        int month = Integer.parseInt(birth.substring(birth.indexOf("-") + 1,
                birth.lastIndexOf("-")));
        int day = Integer.parseInt(birth.substring(birth.lastIndexOf("-") + 1));
        String s = "魔羯水瓶双鱼牡羊金牛双子巨蟹狮子处女天秤天蝎射手魔羯";
        int[] arr = {20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22};
        int start = month * 2 - (day < arr[month - 1] ? 2 : 0);
        return s.substring(start, start + 2) + "座";
    }

    /**
     * 判断日期是否有效,包括闰年的情况
     *
     * @param date YYYY-mm-dd
     * @return
     */
    public static boolean isDate(String date) {
        StringBuffer reg = new StringBuffer(
                "^((\\d{2}(([02468][048])|([13579][26]))-?((((0?");
        reg.append("[13578])|(1[02]))-?((0?[1-9])|([1-2][0-9])|(3[01])))");
        reg.append("|(((0?[469])|(11))-?((0?[1-9])|([1-2][0-9])|(30)))|");
        reg.append("(0?2-?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][12");
        reg.append("35679])|([13579][01345789]))-?((((0?[13578])|(1[02]))");
        reg.append("-?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))");
        reg.append("-?((0?[1-9])|([1-2][0-9])|(30)))|(0?2-?((0?[");
        reg.append("1-9])|(1[0-9])|(2[0-8]))))))");
        Pattern p = Pattern.compile(reg.toString());
        return p.matcher(date).matches();
    }

    /**
     * 取得指定日期过 months 月后的日期 (当 months 为负数表示指定月之前);
     *
     * @param date   日期 为null时表示当天
     * @param months 相加(相减)的月数
     */
    public static Date nextMonth(Date date, int months) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    /**
     * 取得指定日期过 day 天后的日期 (当 day 为负数表示指日期之前);
     *
     * @param date 日期 为null时表示当天
     * @param day  相加(相减)的月数
     */
    public static Date nextDay(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(Calendar.DAY_OF_YEAR, day);
        return cal.getTime();
    }

    /**
     * 取得距离今天 day 日的日期
     *
     * @param day
     * @param format
     * @return
     * @author chenyz
     */
    public static String nextDay(int day, String format) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR, day);
        return dateToString(cal.getTime(), format);
    }

    /**
     * 取得指定日期过 day 周后的日期 (当 day 为负数表示指定月之前)
     *
     * @param date 日期 为null时表示当天
     */
    public static Date nextWeek(Date date, int week) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(Calendar.WEEK_OF_MONTH, week);
        return cal.getTime();
    }

    /**
     * 获取当前的日期(yyyy-MM-dd)
     */
    public static String currDay() {
        return DateTimeUtil.dateToString(new Date(), DateTimeUtil.LONG_DATE_FORMAT);
    }

    public static String currFullDay() {
        return DateTimeUtil.dateToString(new Date(), DateTimeUtil.FORMAT_ONE);
    }

    /**
     * 获取昨天的日期
     *
     * @return
     */
    public static String befoDay() {
        return befoDay(DateTimeUtil.LONG_DATE_FORMAT);
    }

    /**
     * 根据时间类型获取昨天的日期
     *
     * @param format
     * @return
     * @author chenyz
     */
    public static String befoDay(String format) {
        return DateTimeUtil.dateToString(DateTimeUtil.nextDay(new Date(), -1), format);
    }

    /**
     * 获取明天的日期
     */
    public static String afterDay() {
        return DateTimeUtil.dateToString(DateTimeUtil.nextDay(new Date(), 1),
                DateTimeUtil.LONG_DATE_FORMAT);
    }

    /**
     * 取得当前时间距离1900/1/1的天数
     *
     * @return
     */
    public static int getDayNum() {
        int daynum = 0;
        GregorianCalendar gd = new GregorianCalendar();
        Date dt = gd.getTime();
        GregorianCalendar gd1 = new GregorianCalendar(1900, 1, 1);
        Date dt1 = gd1.getTime();
        daynum = (int) ((dt.getTime() - dt1.getTime()) / (24 * 60 * 60 * 1000));
        return daynum;
    }

    /**
     * getDayNum的逆方法(用于处理Excel取出的日期格式数据等)
     *
     * @param day
     * @return
     */
    public static Date getDateByNum(int day) {
        GregorianCalendar gd = new GregorianCalendar(1900, 1, 1);
        Date date = gd.getTime();
        date = nextDay(date, day);
        return date;
    }

    /**
     * 针对yyyy-MM-dd HH:mm:ss格式,显示yyyymmdd
     */
    public static String getYmdDateCN(String datestr) {
        if (datestr == null)
            return "";
        if (datestr.length() < 10)
            return "";
        StringBuffer buf = new StringBuffer();
        buf.append(datestr.substring(0, 4)).append(datestr.substring(5, 7))
                .append(datestr.substring(8, 10));
        return buf.toString();
    }

    /**
     * 获取本月第一天
     *
     * @param format
     * @return
     */
    public static String getFirstDayOfMonth(String format) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        return dateToString(cal.getTime(), format);
    }

    public static Date getFirstDayOfMonth(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取本月最后一天
     *
     * @param format
     * @return
     */
    public static String getLastDayOfMonth(String format) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        return dateToString(cal.getTime(), format);
    }

    public static Date getLastDayOfMonth(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.set(Calendar.DATE, 1);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    public static Date getFirstDateOfDay(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    public static Date getLastDateOfDay(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 随意日期找到当周的第一天
     *
     * @param time
     * @return
     */
    public static Date getFirstDateOfWeek(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 随意日期找到当周的最后一天
     *
     * @param time
     * @return
     */
    public static Date getLastDateOfWeek(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + 6);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 格式化字符串日期 yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String formatString(String date) {
        Date d = stringtoDate(date, LONG_DATE_FORMAT);
        String dateFormat = DateTimeUtil.dateToString(d, LONG_DATE_FORMAT);
        return dateFormat;
    }

    /**
     * 格式化长字符串日期 yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String formatLString(String date) {
        Date d = stringtoDate(date, FORMAT_ONE);
        String dateFormat = dateToString(d, FORMAT_ONE);
        return dateFormat;
    }

    /**
     * 把CST格式转换成普通日期格式    ranling
     *
     * @param cstTime
     * @return
     */
    public static String timeCST2SimpleDate(String cstTime) {
        DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'CST' yyyy", Locale.US);
        try {
            Date date = df.parse(cstTime);
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getTime(String date, String flag) {
        if (date.trim().indexOf(" ") == -1) {
            String[] tmp = date.split(" ");
            if (tmp.length == 2) {
                return date;
            } else {
                if (flag.equals("start")) {
                    return date.trim() + " 00:00:00";
                } else {
                    return date.trim() + " 23:59:59";
                }
            }
        }
        return date;
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param pattern
     * @return
     * @author xuyl
     */
    public static String format(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static String format(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(FORMAT_ONE).format(date);
    }

    /**
     * 获取时间是否在范围内
     *
     * @param date  对比的时间
     * @param begin 开始时间
     * @param end   结束时间
     * @return boolean true 在 false 不在
     * @author hanrb
     */
    public static boolean inDate(Date date, Date begin, Date end) {
        if (date.compareTo(begin) >= 0 && date.compareTo(end) < 1) {
            return true;
        }
        return false;
    }


    public static String dateConverString(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int year = c.get(Calendar.YEAR);
        String yearStr = StringUtils.substring(String.valueOf(year), 2);
        int month = c.get(Calendar.MONTH) + 1;
        return yearStr + "年" + month + "月";
    }

    /**
     * 获取两个日期之间的所有日期,包括本身
     *
     * @date 2013-09-11
     * @author hejianming
     */
    public static List<Date> betweendates(Date date1, Date date2) {
        List<Date> list = new ArrayList<Date>();
        long num = dayDiff(date1, date2);
        list.add(date1);
        if (num > 0) {
            for (int i = 1; i < num; i++) {
                list.add(nextDay(date1, i));
            }
        }
        return list;
    }

    /**
     * 获取两个日期之间的所有日期,包括本身
     *
     * @date 2013-09-11
     * @author hejianming
     */
    public static List<String> betweendatesToString(Date date1, Date date2) {
        List<String> list = new ArrayList<String>();
        long num = dayDiff(date1, date2);
        list.add(format(date1, "yyyy-MM-dd"));
        if (num > 0) {
            for (int i = 1; i <= num; i++) {
                list.add(format(nextDay(date1, i), "yyyy-MM-dd"));
            }
        }
        return list;
    }

    public static Integer getNowHour(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    public static Integer getNowMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    public static boolean isDay() {
        Date now = new Date();
        Integer hour = getNowHour(now);
//        Integer minute = getNowMinute(now);
        if (hour >= 22) {
//            if (hour == 20) {
//                if (minute > 30) {
            return false;
//                } else {
//                    return true;
//                }
//            }
//            return false;
        } else {
            return true;
        }
    }

    public static long getDayTimeDistance() {
        Date now = new Date();
        Integer hour = getNowHour(now);
        Integer minute = getNowMinute(now);
        if (hour >= 8 && hour <= 19) {
//            if (hour == 17) {
//                if (minute > 30) {
//                    return -1;
//                }
//            }
            Calendar c = Calendar.getInstance();
            c.setTime(now);
            c.set(Calendar.HOUR_OF_DAY, 19);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            return c.getTime().getTime() - now.getTime();
        } else {
            return -1;
        }
    }

    public static long getNightTimeDistance() {
        Date now = new Date();
        Integer hour = getNowHour(now);
        if (hour >= 19 && hour < 24) {
            Calendar c = Calendar.getInstance();
            c.setTime(now);
            c.set(Calendar.HOUR_OF_DAY, 24);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            return c.getTime().getTime() - now.getTime();
        } else {
            return -1;
        }
    }

    public static long getReserveDistance(Date date, String start) {
        Calendar startDate = Calendar.getInstance();
        String[] split = start.split(":");
        startDate.setTime(date);
        startDate.set(Calendar.HOUR_OF_DAY, Integer.parseInt(split[0]));
        startDate.set(Calendar.MINUTE, Integer.parseInt(split[1]));
        Calendar c = Calendar.getInstance();
        return startDate.getTime().getTime() - c.getTime().getTime();
    }

    public static Date getDateByTime(Date date, Integer hour, Integer minute) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    public static String getOrdeNumByDay(Date date) {
        StringBuffer orderIdBuffer = new StringBuffer(DateTimeUtil.format(date, "yyyyMMddHHmmss"));
        orderIdBuffer.append(RandomUtils.nextInt(1000));
        return orderIdBuffer.toString();
    }

    public static String getOrdeNumByDay(String date, String orderNum) {
        String o = orderNum.substring(8);
        return date + o;
    }

    public static String getDateByDay(String dateStr, Date date) {
        String year = dateStr.substring(0, 4);
        String month = dateStr.substring(4, 6);
        String day = dateStr.substring(6, 8);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.YEAR, Integer.parseInt(year));
        c.set(Calendar.MONTH, Integer.parseInt(month) - 1);
        c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
        return DateTimeUtil.dateToString(c.getTime(), "yyyy-MM-dd HH:mm:ss");
    }

    public static String dateStringformat(String dateStr, String format) {
        String format2 = "yyyy-MM-dd";
        Date date = stringtoDate(dateStr, format2);
        return dateToString(date,format);
    }

    /**
     * 获取两个日期相隔天数
     *
     * @return 天
     */
    public static Integer getBetweenDate(String startDate,String endDate) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Long c=0L;
        try {
            c = sf.parse(endDate).getTime()-sf.parse(startDate).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long d = c/1000/60/60/24;//天
        return (int)d;
    }
    /**
     * 获取当前日期是星期几<br>
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    /**
     * 获得num年后的日期
     * @param date
     * @param num
     * @return
     */
    public static Date getNewYear(Date date,int num){
        Calendar calendar =Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)+num);
        return calendar.getTime();
    }


    public static Long secondDiffHM(String bt,String et){
        Calendar c =Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,Integer.parseInt(bt.split(":")[0]));
        c.set(Calendar.MINUTE,Integer.parseInt(bt.split(":")[1]));

        long t1=c.getTime().getTime();
        c.set(Calendar.HOUR_OF_DAY,Integer.parseInt(et.split(":")[0]));
        c.set(Calendar.MINUTE,Integer.parseInt(et.split(":")[1]));
        long t2=c.getTime().getTime();
        return (t2-t1)/1000;
    }



	
	/**
	 * 日期时间转换成文字
	 * @param date
	 * @return
	 */
	public static String getDateTimeString(Date date){
		if(date==null){
			throw new NullPointerException();
		}
		
		Date currentDate = new Date();
		long cha = Math.abs(date.getTime()-currentDate.getTime());
//		System.out.println("cha="+cha);
		long hours = cha/hour;
//		System.out.println(hours);
		if(hours<1){
			if(cha/m<=0){
				return "刚刚";
			}
			return cha/m+"分钟前";
		}
		if(hours<24){
			return cha/hour+"小时前";
		}
		if(hours<=72){
			int nn = Integer.valueOf(cha/day+"");
			if(cha%day>0){
				nn++;
			}
			return nn+"天前";
		}
		return sdf.format(date);
	}
	
	public static boolean compareDateTime(Date d1,Date d2) {
		return d1.getTime() > d2.getTime();
	}
	
	/**
	 * 获取促销商品活动的结束时间的字符串
	 * @return
	 * @throws Exception 
	 */
	public static String getActivityEndDateTimeString(String activityEndDateTime) {
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数   
        long nh = 1000 * 60 * 60;// 一小时的毫秒数   
        long nm = 1000 * 60;// 一分钟的毫秒数   
        long ns = 1000;// 一秒钟的毫秒数   
        long diff;   
        long day = 0;   
        long hour = 0;   
        long min = 0;   
        long sec = 0;   
        // 获得两个时间的毫秒时间差异   
        try {   
            diff = sdf.parse(activityEndDateTime).getTime() - (new Date()).getTime();   
            day = diff / nd;// 计算差多少天   
            hour = diff % nd / nh + day * 24;// 计算差多少小时   
            min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟   
            sec = diff % nd % nh % nm / ns;// 计算差多少秒
            
            StringBuilder buff = new StringBuilder();
            
            if(day > 0){
            	buff.append(day).append("天");
            }
            
            if((hour - day * 24) > 0){
            	buff.append(hour - day * 24).append("小时");
            }
            
            if((min - day * 24 * 60) > 0){
            	buff.append(min - day * 24 * 60).append("分钟");
            }
            
            if(sec > 0){
            	buff.append(sec).append("秒");
            }
            
//            String cha = day + "天" + (hour - day * 24) + "小时"  + (min - day * 24 * 60) + "分钟" + sec + "秒";
            
            return buff.toString();
        } catch (ParseException e) {   
            e.printStackTrace();   
        }
        return null;
	}
    public static void main(String[] args) throws Exception {

//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(getDateTimeString(sdf.parse("2013-11-2 7:00:00")));
//		System.out.println(getDateTimeString(sdf.parse("2013-11-2 6:00:00")));
//		System.out.println(getDateTimeString(sdf.parse("2013-11-1 6:00:00")));
//		System.out.println(getDateTimeString(sdf.parse("2013-10-31 6:00:00")));
////		System.out.println(getDateTimeString(sdf.parse("2013-10-30 8:00:00")));
//		System.out.println(getDateTimeString(sdf.parse("2013-10-30 6:00:00")));
//
//		System.out.println(sdf.format(DateTimeUtil.addHours(new Date(), 2)));

        //System.out.println(getActivityEndDateTimeString("2014-04-30 6:00:00"));


        System.out.println(DateTimeUtil.timeSub("2016-09-06 22:37:50", timeFormat.format(new Date())));
    }
}
