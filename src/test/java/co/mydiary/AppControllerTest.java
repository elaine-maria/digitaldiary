package co.mydiary;

import co.mydiary.controllers.BabyController;
import co.mydiary.dtos.Baby.BabyAllDTO;
import co.mydiary.dtos.Baby.BabyInfoDTO;
import co.mydiary.dtos.Baby.BabyGrowthChartDTO;
import co.mydiary.services.BabyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BabyController.class)
public class AppControllerTest {

    @MockBean
    private BabyService service;

    @Autowired
    private MockMvc mockMVC;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getAllBabyInfo_ScenarioA() throws Exception {

        //arrange
        List<BabyInfoDTO> serviceList = new ArrayList<>();
        BabyInfoDTO babyA = new BabyInfoDTO();
        babyA.setId(1);
        babyA.setName("A");
        babyA.setDescription("Birthday");
        BabyInfoDTO babyB = new BabyInfoDTO();
        babyB.setId(2);
        babyB.setName("B");
        babyB.setDescription("FirstHaircut");
        serviceList.add(babyA);
        serviceList.add(babyB);

        doReturn(serviceList).when(service).getAllBabyInfo();

        List<BabyInfoDTO> expectedList = new ArrayList<>();
        BabyInfoDTO expectedbabyA = new BabyInfoDTO();
        expectedbabyA.setId(1);
        expectedbabyA.setName("A");
        expectedbabyA.setDescription("Birthday");
        BabyInfoDTO expectedbabyB = new BabyInfoDTO();
        expectedbabyB.setId(2);
        expectedbabyB.setName("B");
        expectedbabyB.setDescription("FirstHaircut");
        expectedList.add(expectedbabyA);
        expectedList.add(expectedbabyB);

        String expectedResult = objectMapper.writeValueAsString(expectedList);

        //act
        MvcResult result = mockMVC.perform(MockMvcRequestBuilders.get("/baby/"))
                .andExpect(status().is(200))
                .andReturn();

        String actualResult = result.getResponse().getContentAsString();

        //assert
        Assert.assertThat(actualResult, is(equalTo(expectedResult)));

        //verify
        verify(service, times(1)).getAllBabyInfo();
        verifyNoMoreInteractions(service);

    }

    @Test
    public void getAllBabyGrowthInfo_ScenarioA() throws Exception {

        //arrange
        List<BabyGrowthChartDTO> serviceList = new ArrayList<>();
        BabyGrowthChartDTO babyA = new BabyGrowthChartDTO();
        babyA.setId(1);
        babyA.setName("A");
        babyA.setBabyid(1);
        BabyGrowthChartDTO babyB = new BabyGrowthChartDTO();
        babyB.setId(2);
        babyB.setName("B");
        babyB.setBabyid(2);
        serviceList.add(babyA);
        serviceList.add(babyB);

        doReturn(serviceList).when(service).getAllBabyGrowthInfo();

        List<BabyGrowthChartDTO> expectedList = new ArrayList<>();
        BabyGrowthChartDTO expectedbabyA = new BabyGrowthChartDTO();
        expectedbabyA.setId(1);
        expectedbabyA.setName("A");
        expectedbabyA.setBabyid(1);
        BabyGrowthChartDTO expectedbabyB = new BabyGrowthChartDTO();
        expectedbabyB.setId(2);
        expectedbabyB.setName("B");
        expectedbabyB.setBabyid(2);
        expectedList.add(expectedbabyA);
        expectedList.add(expectedbabyB);

        String expectedResult = objectMapper.writeValueAsString(expectedList);

        //act
        MvcResult result = mockMVC.perform(MockMvcRequestBuilders.get("/baby/babygrowth"))
                .andExpect(status().is(200))
                .andReturn();

        String actualResult = result.getResponse().getContentAsString();

        //assert
        Assert.assertThat(actualResult, is(equalTo(expectedResult)));

        //verify
        verify(service, times(1)).getAllBabyGrowthInfo();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void getAllByName_ScenarioA() throws Exception {

        //arrange
        List<BabyAllDTO> serviceList = new ArrayList<>();
        BabyAllDTO babyA = new BabyAllDTO();
        babyA.setName("A");
        //babyA.setDescription("Birthday");
        BabyAllDTO babyB = new BabyAllDTO();
        babyB.setName("B");
        //babyB.setDescription("FirstHaircut");
        serviceList.add(babyA);
        serviceList.add(babyB);

        doReturn(serviceList).when(service).getAllByName("A");

        List<BabyAllDTO> expectedList = new ArrayList<>();
        BabyAllDTO expectedbabyA = new BabyAllDTO();
        expectedbabyA.setName("A");
        //expectedbabyA.setDescription("Birthday");
        BabyAllDTO expectedbabyB = new BabyAllDTO();
        expectedbabyB.setName("B");
        //expectedbabyB.setDescription("FirstHaircut");
        expectedList.add(expectedbabyA);
        expectedList.add(expectedbabyB);

        String expectedResult = objectMapper.writeValueAsString(expectedList);

        //act
        MvcResult result = mockMVC.perform(MockMvcRequestBuilders.get("/baby/name/A"))
                .andExpect(status().is(200))
                .andReturn();
        String actualResult = result.getResponse().getContentAsString();

        //assert
        Assert.assertThat(actualResult, is(equalTo(expectedResult)));

        //verify
        verify(service, times(1)).getAllByName("A");
        verifyNoMoreInteractions(service);

    }

    @Test
    public void getAllByYear_ScenarioA() throws Exception {

        //arrange
        List<BabyInfoDTO> serviceList = new ArrayList<>();
        BabyInfoDTO babyA = new BabyInfoDTO();
        babyA.setId(1);
        //babyA.setEventday(2011-10-23 20-20-45);
        //babyA.setDescription("Birthday");
        BabyInfoDTO babyB = new BabyInfoDTO();
        babyB.setId(2);
        babyB.setName("B");
        //babyB.setDescription("FirstHaircut");
        serviceList.add(babyA);
        serviceList.add(babyB);

        doReturn(serviceList).when(service).getAllByName("A");
    }

    @Test
    public void addNewGrowthEntry_ScenarioA() throws Exception {

        //arrange
        BabyGrowthChartDTO serviceEntry = new BabyGrowthChartDTO();
        serviceEntry.setName("A");

        doReturn(serviceEntry).when(service).addNewGrowthEntry(serviceEntry);

        //act
        BabyGrowthChartDTO requestedEntry = new BabyGrowthChartDTO();
        requestedEntry.setName("A");
        String requestBody = objectMapper.writeValueAsString(requestedEntry);

        MvcResult result = mockMVC.perform(MockMvcRequestBuilders.post("/baby/addgrowth").content(requestBody).contentType("application/json"))
                .andExpect(status().is(200))
                .andReturn();


        String actualResult = result.getResponse().getContentAsString();

        String expectedResult = objectMapper.writeValueAsString(requestedEntry);

        //assert
        Assert.assertThat(actualResult, is(equalTo(expectedResult)));

        //verify
        verify(service, times(1)).addNewGrowthEntry(serviceEntry);
        verifyNoMoreInteractions(service);

    }
}
