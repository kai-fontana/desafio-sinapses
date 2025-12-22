package br.com.zaffari.sinapses.service;

import java.util.List;

import br.com.zaffari.sinapses.model.Sinapse;

public interface SinapseService {
    public List<Sinapse> create(Sinapse sinapse);

    public List<Sinapse> list();

    public List<Sinapse> update(Sinapse sinapse);

    public List<Sinapse> delete(Sinapse id);
}