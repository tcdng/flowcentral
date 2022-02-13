/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.flowcentraltech.flowcentral.application.entities.AppAppletFilter;
import com.flowcentraltech.flowcentral.configuration.xml.FilterConfig;
import com.flowcentraltech.flowcentral.configuration.xml.FilterRestrictionConfig;
import com.tcdng.unify.core.AbstractUnifyComponentTest;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.criterion.Amongst;
import com.tcdng.unify.core.criterion.And;
import com.tcdng.unify.core.criterion.Between;
import com.tcdng.unify.core.criterion.Equals;
import com.tcdng.unify.core.criterion.FilterConditionType;
import com.tcdng.unify.core.criterion.IsNull;
import com.tcdng.unify.core.criterion.Or;
import com.tcdng.unify.core.util.CalendarUtils;

/**
 * Tests input widget utilities class.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class InputWidgetUtilsTest extends AbstractUnifyComponentTest {

    @Test
    public void testFilterDefinitionFromSimpleRestriction() throws UnifyException {
        String definition = InputWidgetUtils.getFilterDefinition(new IsNull("name"));
        assertEquals("NL]0]name]\r\n", definition);

        definition = InputWidgetUtils.getFilterDefinition(new Equals("name", "Amina"));
        assertEquals("EQ]0]name]Amina]\r\n", definition);

        Calendar cal = Calendar.getInstance();
        cal.set(2021, 11, 25);
        Date date1 = CalendarUtils.getMidnightDate(cal.getTime());

        cal.set(2021, 10, 4);
        Date date2 = CalendarUtils.getMidnightDate(cal.getTime());

        definition = InputWidgetUtils.getFilterDefinition(new Between("birthDt", date1, date2));
        assertEquals("BT]0]birthDt]2021-12-25 00:00:00.000]2021-11-04 00:00:00.000]\r\n", definition);

        definition = InputWidgetUtils.getFilterDefinition(new Amongst("name", Arrays.asList("Amina", "Zainab")));
        assertEquals("IN]0]name]Amina|Zainab]\r\n", definition);
    }

    @Test
    public void testFilterDefinitionFromCompoundRestriction() throws UnifyException {
        String definition = InputWidgetUtils
                .getFilterDefinition(new And().add(new IsNull("name")).add(new Equals("name", "Amina")));
        assertEquals("AND]0]\r\nNL]1]name]\r\nEQ]1]name]Amina]\r\n", definition);
    }

    @Test
    public void testFilterDefinitionFromCompoundRestrictionDeep() throws UnifyException {
        Calendar cal = Calendar.getInstance();
        cal.set(2021, 11, 25);
        Date date1 = CalendarUtils.getMidnightDate(cal.getTime());
        cal.set(2021, 10, 4);
        Date date2 = CalendarUtils.getMidnightDate(cal.getTime());
        String definition = InputWidgetUtils.getFilterDefinition(new And().add(new IsNull("name"))
                .add(new Equals("name", "Amina")).add(new Or().add(new Between("birthDt", date1, date2))
                        .add(new Amongst("name", Arrays.asList("Amina", "Zainab")))));
        assertEquals(
                "AND]0]\r\nNL]1]name]\r\nEQ]1]name]Amina]\r\nOR]1]\r\nBT]2]birthDt]2021-12-25 00:00:00.000]2021-11-04 00:00:00.000]\r\nIN]2]name]Amina|Zainab]\r\n",
                definition);
    }

    @Test
    public void testGetFilterConfig() throws Exception {
        FilterConfig filterConfig = InputWidgetUtils
                .getFilterConfig(new AppAppletFilter("test1", "Test 1", "EQ]0]type]BSE]\r\n" + ""));
        assertNotNull(filterConfig);
        assertEquals("test1", filterConfig.getName());
        assertEquals("Test 1", filterConfig.getDescription());
        List<FilterRestrictionConfig> list = filterConfig.getRestrictionList();
        assertNotNull(list);
        assertEquals(1, list.size());

        FilterRestrictionConfig cfg = list.get(0);
        assertNotNull(cfg);
        assertEquals(FilterConditionType.EQUALS, cfg.getType());
        assertEquals("type", cfg.getField());
        assertEquals("BSE", cfg.getParamA());
        assertNull(cfg.getParamB());

        filterConfig = InputWidgetUtils.getFilterConfig(new AppAppletFilter("test2", "Test 2",
                "AND]0]\r\n" + "IN]1]type]MEL|MEA|CEN|DIM]\r\n" + "NL]1]entity]\r\n" + ""));
        assertNotNull(filterConfig);
        assertEquals("test2", filterConfig.getName());
        assertEquals("Test 2", filterConfig.getDescription());
        list = filterConfig.getRestrictionList();
        assertNotNull(list);
        assertEquals(1, list.size());

        cfg = list.get(0);
        assertNotNull(cfg);
        assertEquals(FilterConditionType.AND, cfg.getType());
        assertNull(cfg.getField());
        assertNull(cfg.getParamA());
        assertNull(cfg.getParamB());

        list = cfg.getRestrictionList();
        assertNotNull(list);
        assertEquals(2, list.size());

        cfg = list.get(0);
        assertNotNull(cfg);
        assertEquals(FilterConditionType.AMONGST, cfg.getType());
        assertEquals("type", cfg.getField());
        assertEquals("MEL|MEA|CEN|DIM", cfg.getParamA());
        assertNull(cfg.getParamB());

        cfg = list.get(1);
        assertNotNull(cfg);
        assertEquals(FilterConditionType.IS_NULL, cfg.getType());
        assertEquals("entity", cfg.getField());
        assertNull(cfg.getParamA());
        assertNull(cfg.getParamB());

        filterConfig = InputWidgetUtils
                .getFilterConfig(new AppAppletFilter("test3", "Test 3", "AND]0]\r\n" + "EQ]1]category]SHT]\r\n"
                        + "OR]1]\r\n" + "GT]2]costPrice]30.00]\r\n" + "GT]2]salesPrice]50.00]\r\n" + ""));
        assertNotNull(filterConfig);
        assertEquals("test3", filterConfig.getName());
        assertEquals("Test 3", filterConfig.getDescription());
        list = filterConfig.getRestrictionList();
        assertNotNull(list);
        assertEquals(1, list.size());

        cfg = list.get(0);
        assertNotNull(cfg);
        assertEquals(FilterConditionType.AND, cfg.getType());
        assertNull(cfg.getField());
        assertNull(cfg.getParamA());
        assertNull(cfg.getParamB());

        list = cfg.getRestrictionList();
        assertNotNull(list);
        assertEquals(2, list.size());

        cfg = list.get(0);
        assertNotNull(cfg);
        assertEquals(FilterConditionType.EQUALS, cfg.getType());
        assertEquals("category", cfg.getField());
        assertEquals("SHT", cfg.getParamA());
        assertNull(cfg.getParamB());

        cfg = list.get(1);
        assertNotNull(cfg);
        assertEquals(FilterConditionType.OR, cfg.getType());
        assertNull(cfg.getField());
        assertNull(cfg.getParamA());
        assertNull(cfg.getParamB());

        list = cfg.getRestrictionList();
        assertNotNull(list);
        assertEquals(2, list.size());

        cfg = list.get(0);
        assertNotNull(cfg);
        assertEquals(FilterConditionType.GREATER_THAN, cfg.getType());
        assertEquals("costPrice", cfg.getField());
        assertEquals("30.00", cfg.getParamA());
        assertNull(cfg.getParamB());

        cfg = list.get(1);
        assertNotNull(cfg);
        assertEquals(FilterConditionType.GREATER_THAN, cfg.getType());
        assertEquals("salesPrice", cfg.getField());
        assertEquals("50.00", cfg.getParamA());
        assertNull(cfg.getParamB());
    }

    @Override
    protected void onSetup() throws Exception {

    }

    @Override
    protected void onTearDown() throws Exception {

    }

}