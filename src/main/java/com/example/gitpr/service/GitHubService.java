package com.example.gitpr.service;

import com.example.gitpr.Model.PRModel;
import com.example.gitpr.Model.RepoObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.example.gitpr.Model.RepoObject;
import com.example.gitpr.Model.License;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class GitHubService {

    RestClient restClient=RestClient.create();
    List<String> openSourcelicenses=new ArrayList<>(){
        {
            add("0BSD");
            add("AAL");
            add("AFL-3.0");
            add("AGPL-3.0-only");
            add("Apache-1.1");
            add("Apache-2.0");
            add("APL-1.0");
            add("APSL-2.0");
            add("Artistic-1.0");
            add("Artistic-1.0-Perl");
            add("Artistic-2.0");
            add("BlueOak-1.0.0");
            add("BSD-1-Clause");
            add("BSD-2-Clause");
            add("BSD-2-Clause-Patent");
            add("BSD-3-Clause");
            add("BSD-3-Clause-LBNL");
            add("BSL-1.0");
            add("CAL-1.0");
            add("CATOSL-1.1");
            add("CDDL-1.0");
            add("CECILL-2.1");
            add("CERN-OHL-P-2.0");
            add("CERN-OHL-S-2.0");
            add("CERN-OHL-W-2.0");
            add("CNRI-Python");
            add("CPAL-1.0");
            add("CPL-1.0");
            add("CUA-OPL-1.0");
            add("ECL-1.0");
            add("ECL-2.0");
            add("eCos-2.0");
            add("EFL-1.0");
            add("EFL-2.0");
            add("Entessa");
            add("EPL-1.0");
            add("EPL-2.0");
            add("EUDatagrid");
            add("EUPL-1.1");
            add("EUPL-1.2");
            add("Fair");
            add("Frameworx-1.0");
            add("GPL-2.0");
            add("GPL-3.0-only");
            add("HPND");
            add("ICU");
            add("Intel");
            add("IPA");
            add("IPL-1.0");
            add("ISC");
            add("Jam");
            add("LGPL-2.0-only");
            add("LGPL-2.1");
            add("LGPL-3.0-only");
            add("LiLiQ-P-1.1");
            add("LiLiQ-R-1.1");
            add("LiLiQ-Rplus-1.1");
            add("LPL-1.0");
            add("LPL-1.02");
            add("LPPL-1.3c");
            add("MirOS");
            add("MIT");
            add("MIT-0");
            add("MIT-CMU");
            add("Motosoto");
            add("MPL-1.0");
            add("MPL-1.1");
            add("MPL-2.0");
            add("MS-PL");
            add("MS-RL");
            add("MulanPSL-2.0");
            add("Multics");
            add("NASA-1.3");
            add("Naumen");
            add("NCSA");
            add("NGPL");
            add("NOKIA");
            add("NPOSL-3.0");
            add("NTP");
            add("OFL-1.1");
            add("OGTSL");
            add("OLDAP-2.8");
            add("OLFL-1.3");
            add("OSET-PL-2.1");
            add("OSL-1.0");
            add("OSL-2.1");
            add("OSL-3.0");
            add("PHP-3.0");
            add("PHP-3.01");
            add("PostgreSQL");
            add("PSF-2.0");
            add("QPL-1.0");
            add("RPL-1.1");
            add("RPL-1.5");
            add("RPSL-1.0");
            add("RSCPL");
            add("SimPL-2.0");
            add("SISSL");
            add("Sleepycat");
            add("SPL-1.0");
            add("UCL-1.0");
            add("Unicode-DFS-2015");
            add("Unlicense");
            add("UPL-1.0");
            add("VSL-0.1");
            add("W3C-20150513");
            add("Watcom-1.0");
            add("wxWindows");
            add("Xnet");
            add("Zlib");
            add("ZPL-2.0");
            add("ZPL-2.1");
        }
    };
    List<RepoObject> openSourceRepos = new ArrayList<>();


    public List<RepoObject>  GetCommits(){

         RepoObject[] result=
                restClient.get().
                        uri("https://api.github.com/users/sreekarsai193/repos")
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .body(RepoObject[].class);
        for(RepoObject repo: result){
            if(isOpenSource(repo)){
                openSourceRepos.add(repo);
            }
        }
        return openSourceRepos;
    }
    private boolean isOpenSource(RepoObject repo) {
        if(repo.getLicense() == null) {
            return false;
        }
        for(String spdx : openSourcelicenses) {
            if (repo.getLicense().getSpdx_id().equals(spdx)) {
                return true;
            }
        }
        return false;
    }
    public List<PRModel>  getPrsFromOpenSource() throws Exception{
        List<PRModel> allprs=new ArrayList<>();
        for(RepoObject repo:openSourceRepos){
            allprs.addAll(getPRs(repo));
        }
        return  allprs;
    }

    public List<PRModel> getPRs(RepoObject repo) throws Exception{

      PRModel[] prs=restClient.get().
              uri("https://api.github.com/repos/sreekarsai193/"+ repo.getName()+"/commits").
                accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(PRModel[].class);

      if(prs==null) throw new Exception("Prs is null");
      else System.out.println(repo.getName());
      return Arrays.asList(prs);


    }


}
