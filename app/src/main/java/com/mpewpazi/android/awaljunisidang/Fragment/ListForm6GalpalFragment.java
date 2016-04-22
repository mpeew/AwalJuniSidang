package com.mpewpazi.android.awaljunisidang.Fragment;


import android.support.v4.app.Fragment;

/**
 * Created by mpewpazi on 4/22/16.
 */
public class ListForm6GalpalFragment extends Fragment {/*
    private RecyclerView mFormGalpal6RecyclerView;
    private FormGalpal6Adapter mAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_galpal6_list, container, false);

        mFormGalpal6RecyclerView = (RecyclerView) view.findViewById(R.id.form_galpal6_recycler_view);

        //recycler view butuh layoutmanager untuk mempossionig item di screen
        //ada banyak macam layout manager, kalau linear itu untuk vertikal posisioningnya
        //kedepanya ada gridLayoutManager
        mFormGalpal6RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        FormGalpal6Lab crimeLab = FormGalpal6Lab.get(getActivity());
        List<FormGalpal6> crimes = crimeLab.getFormGalpal6s();

        if (mAdapter == null) {
            mAdapter = new FormGalpal6Adapter(crimes);
            mFormGalpal6RecyclerView.setAdapter(mAdapter);
        } else {

            //reload all the item in he list
            mAdapter.notifyDataSetChanged();
        }
    }

    private class FormGalpal6Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mSolvedCheckBox;

        private FormGalpal6 mFormGalpal6;

        public void bindFormGalpal6(FormGalpal6 crime) {
            mFormGalpal6 = crime;
            mTitleTextView.setText(mFormGalpal6.getTitle());
            mDateTextView.setText(mFormGalpal6.getDate().toString());
            mSolvedCheckBox.setChecked(mFormGalpal6.isSolved());
        }

        public FormGalpal6Holder(View itemView) {
            //setiap ada yang masuk ke super , reference setiap wideget dibuat oleh parent
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_crime_title_text_view);
            mDateTextView = (TextView) itemView.findViewById(R.id.list_item_date_text_view);
            mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_crime_solved_check_box);


        }


        @Override
        public void onClick(View v) {
            Intent intent = FormGalpal6PagerActivity.newIntent(getActivity(), mFormGalpal6.getId());
            startActivity(intent);
        }
    }

    private class FormGalpal6Adapter extends RecyclerView.Adapter<FormGalpal6Holder> {
        private List<FormGalpal6> mFormGalpal6s;

        public FormGalpal6Adapter(List<FormGalpal6> crimes) {
            mFormGalpal6s = crimes;
        }

        @Override
        public FormGalpal6Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_crime, parent, false);
            return new FormGalpal6Holder(view);
        }

        @Override
        public void onBindViewHolder(FormGalpal6Holder holder, int position) {
            FormGalpal6 crime = mFormGalpal6s.get(position);
            holder.bindFormGalpal6(crime);
        }

        @Override
        public int getItemCount() {
            return mFormGalpal6s.size();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_crime_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_new_crime:
                FormGalpal6 crime = new FormGalpal6();
                FormGalpal6Lab.get(getActivity()).addFormGalpal6(crime);
                Intent intent = FormGalpal6PagerActivity.newIntent(getActivity(), crime.getId());
                startActivity(intent);
                return true;
            case R.id.menu_item_show_subtitle:
                updateSubtitle();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
*/
}