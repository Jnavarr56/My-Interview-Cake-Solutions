def merge_ranges(meetings)

    meetings.sort! { |x, y| x[0] <=> y[0] } 

    mgd = []

    mgd_mtg = meetings[0]

    i = 0
        
    while i < meetings.length

        if meetings[i][0] >= mgd_mtg[0] && meetings[i][0] <= mgd_mtg[1]

            mgd_mtg = [mgd_mtg[0], [mgd_mtg[1], meetings[i][1]].max] 

        else

            mgd.push(mgd_mtg)

            mgd_mtg = meetings[i]

       end

       mgd.push(mgd_mtg) if i == meetings.length - 1

       i += 1

    end

    mgd

end


meetings = [[0, 1], [3, 5], [4, 8], [10, 12], [9, 10]]
puts merge_ranges(meetings).inspect
